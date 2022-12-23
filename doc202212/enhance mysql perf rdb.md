
enhance mysql perf rdb

单机上

<!-- TOC -->

- [管道模式 提升30%](#管道模式-提升30)
- [could db rds](#could-db-rds)
- [分实例部署 80%去除事务](#分实例部署-80去除事务)
- [多数据库模式pgsql mgdb rds](#多数据库模式pgsql-mgdb-rds)
- [部分业务替换为mgdb 80%](#部分业务替换为mgdb-80)
- [优先级分级 优先提升20%的业务](#优先级分级-优先提升20的业务)
- [针对业务单独设置btree hash索引](#针对业务单独设置btree-hash索引)
- [大力减少join 嵌入而不是引用](#大力减少join-嵌入而不是引用)
- [多使用json类型数据，部分模块替换为pgsql](#多使用json类型数据部分模块替换为pgsql)
- [单表读写 不要join](#单表读写-不要join)
- [read cache mybatis rds](#read-cache-mybatis-rds)
- [write cache rds mq](#write-cache-rds-mq)
  - [多级cache file cache](#多级cache-file-cache)

<!-- /TOC -->

# 管道模式 提升30%

# could db rds

# 分实例部署 80%去除事务

# 多数据库模式pgsql mgdb rds

# 部分业务替换为mgdb 80%

# 优先级分级 优先提升20%的业务

# 针对业务单独设置btree hash索引
利用mgdb设置索引btree hash ，rds设置hash索引

# 大力减少join 嵌入而不是引用
嵌入式文档是存储相关数据（尤其是定期一起访问的数据）的一种高效且干净的方式。通常，在为 MongoDB 设计模式时，默认情况下应该首选嵌入，并且仅在值得时才使用引用和应用程序端或数据库端联接。给定工作负载检索单个文档并拥有所需所有数据的频率越高，应用程序的性能就越一致

# 多使用json类型数据，部分模块替换为pgsql

# 单表读写 不要join

# read cache mybatis rds

# write cache rds mq

## 多级cache file cache
