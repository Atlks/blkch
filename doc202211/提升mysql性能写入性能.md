提升mysql性能写入性能 单机模式


读性能有很多方案，和集群分摊，很容易集群负载均衡。。
但是写入性能就很需要了。。

调整路线图

<!-- TOC -->

- [性能更高pgsql mariadb](#性能更高pgsql-mariadb)
  - [不用改动代码的 只配参数](#不用改动代码的-只配参数)
  - [写点sql代码的](#写点sql代码的)
- [最后方案 mongodb mq](#最后方案-mongodb-mq)
- [HandlerSocket直接读写socket接口 nosql](#handlersocket直接读写socket接口-nosql)
- [canshu](#canshu)
  - [innodb\_flush\_log\_at\_trx\_commit提升20倍](#innodb_flush_log_at_trx_commit提升20倍)

<!-- /TOC -->
# 性能更高pgsql mariadb

## 不用改动代码的 只配参数

mq性能调优，insert类优先
索引只用最简单的prikey模式，
事务日志改为定时刷新模式。
innodb_flush_log_at_trx_commit = 2 可以获得接近的读取性能 (相差百倍) 。
增加insert cache
为每个表分别创建 InnoDB FILE
适当分区
 定期优化重建数据库 减少碎片
 使用命名管道模式，节约网络io
 适当存储过程，节约网络io
 适当触发器 减少网络io

 4. 减少磁盘写入操作
4.1 使用足够大的写入缓存 innodb_log_file_size
但是需要注意如果用 1G 的 innodb_log_file_size ，假如服务器当机，需要 10 分钟来恢复。

推荐 innodb_log_file_size 设置为 0.25 * innodb_buffer_pool_size

4.2 innodb_flush_log_at_trx_commit
这个选项和写磁盘操作密切相关：

innodb_flush_log_at_trx_commit = 1 则每次修改写入磁盘
innodb_flush_log_at_trx_commit = 0/2 每秒写入磁盘

如果你的应用不涉及很高的安全性 (金融系统)，或者基础架构足够安全，或者 事务都很小，都可以用 0 或者 2 来降低磁盘操作。

4.3 避免双写入缓冲
innodb_flush_method=O_DIRECT

3.调整参数sync_binlog = N
表示执行每写N次操作系统缓冲就执行一次刷新操作,配合innodb_flush_log_at_trx_commit参数可以控制数据丢失的范围

8. 激进的方法，使用内存磁盘
现在基础设施的可靠性已经非常高了，比如 EC2 几乎不用担心服务器硬件当机。而且内存实在是便宜，很容易买到几十G内存的服务器，可以用内存磁盘，定期备份到磁盘。

## 写点sql代码的
静止自动commit，只批量commit
先insert到内存表，然后timer同步到实际表
事务隔离级别使用更简单的。

# 最后方案 mongodb mq
写入mongodb ，同步到db。。
代码改为去join单表模式
最后直接读取mgdb即可。。。
 比较厉害，单改代码比较大。

# HandlerSocket直接读写socket接口 nosql
用 HandlerSocket 跳过 MYSQL 的 SQL 解析层，MYSQL 就真正变成了 NOSQL。

HandlerSocket是MariaDB的NoSQL插件。它作为 mysqld 进程内的守护进程，接受 TCP 连接并执行来自客户端的请求。 HandlerSocket 不支持 SQL 查询。相反，它支持对表执行简单的 CRUD 操作。

在某些情况下，HandlerSocket 可能比 mysqld/libmysql 快得多，因为它的 CPU、磁盘和网络开销更低：

为了降低 CPU 使用率，它不会解析 SQL。
接下来，它会在可能的情况下批处理请求，从而进一步降低 CPU 使用率并降低磁盘使用率。
最后，与mysql / libmysql相比，客户端/服务器协议非常紧凑，从而减少了网络使用量。


# canshu

##  innodb_flush_log_at_trx_commit提升20倍

但是这种情况下，会导致频繁的io操作，因此该模式也是最慢的一种方式。

当innodb_flush_log_at_trx_commit设置为0，mysqld进程的崩溃会导致上一秒钟所有事务数据的丢失。
当innodb_flush_log_at_trx_commit设置为2，只有在操作系统崩溃或者系统掉电的情况下，上一秒钟所有事务数据才可能丢失。
针对同一个表通过c#代码按照系统业务流程进行批量插入，性能比较如下所示：

（a.相同条件下：innodb_flush_log_at_trx_commit=0，插入50W行数据所花时间25.08秒;
（b.相同条件下：innodb_flush_log_at_trx_commit=1，插入50W行数据所花时间17分21.91秒;
（c.相同条件下：innodb_flush_log_at_trx_commit=2，插入50W行数据所花时间1分0.35秒。
————————————————
2核4G这么低的硬件配置，由于参数设置的合理性，已经能抗住每秒数千次，每分钟8万多次的读写请求了。

而假如在写入数据量远大于读的场景，或者说方便随便改动参数的场景，可以针对大批量的数据导入，再做调整，把log_file_size调整的更大，可以达到innodb_buffer_pool_size的25%~100%。

（6) innodb_buffer_pool_size设置MySQL Innodb的可用缓存大小。理论上最大可以设置为服务器总内存的80%.

设置越大的值，当然比设置小的值的写入性能更好。比如上面的参数innodb_log_file_size就是参考innodb_buffer_pool_size的大小来设置的。

（7) innodb_thread_concurrency=16

故名思意，控制并发线程数，理论上线程数越多当然会写入越快。当然也不能设置过大官方建议是CPU核数的两倍左右最合适。

（
————————————————
9) innodb_buffer_pool_instance

默认为1，主要设置内存缓冲池的个数，简单一点来说，是控制并发读写innodb_buffer_pool的个数。

在大批量写入的场景，同样可以调大该参数，也会带来显著的性能提升。

（10) bin_log

二进制日志，通常会记录数据库的所有增删改操作。然而在大量导数据，比如数据库还原的时候不妨临时关闭bin_log,关掉对二进制日志的写入，让数据只写入数据文件，迅速完成数据恢复，完了再开启
————————————————
2、减少磁盘IO，提高磁盘读写效率

分表

（2)：硬件优化

a: 在资源有限的情况下，安装部署的时候，操作系统中应有多个磁盘，把应用程序，数据库文件，日志文件等分散到不同的磁盘存储，减轻每个磁盘的IO，从而提升单个磁盘的写入性能。

b：采用固态硬盘SSD

如果资源足够可以采用SSD存储，SSD具有高速写入的特性，同样也能显著提升所有的磁盘IO操作。
 