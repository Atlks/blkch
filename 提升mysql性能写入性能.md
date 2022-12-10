提升mysql性能写入性能 单机模式


读性能有很多方案，和集群分摊，很容易集群负载均衡。。
但是写入性能就很需要了。。

调整路线图

<!-- TOC -->

- [性能更高pgsql mariadb](#性能更高pgsql-mariadb)
  - [不用改动代码的 只配参数](#不用改动代码的-只配参数)
  - [写点sql代码的](#写点sql代码的)
- [最后方案mq](#最后方案mq)
- [HandlerSocket直接读写socket接口 nosql](#handlersocket直接读写socket接口-nosql)

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

# 最后方案mq
mq比较厉害，单改代码比较大。

# HandlerSocket直接读写socket接口 nosql
用 HandlerSocket 跳过 MYSQL 的 SQL 解析层，MYSQL 就真正变成了 NOSQL。

HandlerSocket是MariaDB的NoSQL插件。它作为 mysqld 进程内的守护进程，接受 TCP 连接并执行来自客户端的请求。 HandlerSocket 不支持 SQL 查询。相反，它支持对表执行简单的 CRUD 操作。

在某些情况下，HandlerSocket 可能比 mysqld/libmysql 快得多，因为它的 CPU、磁盘和网络开销更低：

为了降低 CPU 使用率，它不会解析 SQL。
接下来，它会在可能的情况下批处理请求，从而进一步降低 CPU 使用率并降低磁盘使用率。
最后，与mysql / libmysql相比，客户端/服务器协议非常紧凑，从而减少了网络使用量。