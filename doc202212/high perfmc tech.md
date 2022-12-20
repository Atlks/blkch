high perfmc tech


<!-- TOC -->

- [节流](#节流)
  - [data index trig sync](#data-index-trig-sync)
  - [管道 去除net开销](#管道-去除net开销)
  - [emb db](#emb-db)
  - [db api nosql](#db-api-nosql)
- [开源  fuzai junhen](#开源--fuzai-junhen)
- [优化效率](#优化效率)
  - [add idx](#add-idx)
  - [enhs perf couchdb mgdb rds](#enhs-perf-couchdb-mgdb-rds)
  - [chache](#chache)

<!-- /TOC -->


# 节流
## data index trig sync
mq rds

## 管道 去除net开销

（1）因为数据库程序库同应用程序在相同的地址空间中运行，所以数据库操作不需要进程间的通讯。在一台机器的不同进程间或在网络中不同机器间进行进程通讯所花费的开销，要远远大于函数调用的开销

## emb db
常用的嵌入式数据库的比较
2.1 Berkeley DB
　　技术特点：
　　1. Berkeley DB是一个开放源代码的内嵌式数据库管理系统，能够为应用程序提供高性能的数据管理服务。应用它程序员只需要调用一些简单的API就可以完成对数据的访问和管理。(不使用SQL语言)
　　2. Berkeley DB为许多编程语言提供了实用的API接口，包括C、C++、Java、Perl、Tcl、Python和PHP等。所有同数据库相关的操作都由Berkeley DB函数库负责统一完成。
　　3. Berkeley DB轻便灵活（Portable），可以运行于几乎所有的UNIX和Linux系统及其变种系统、Windows操作系统以及多种嵌入式实时操作系统之下。Berkeley DB被链接到应用程序中，终端用户一般根本感觉不到有一个数据库系统存在。
　　4. Berkeley DB是可伸缩（Scalable）的，这一点表现在很多方面。Database library本身是很精简的（少于300KB的文本空间），但它能够管理规模高达256TB的数据库。它支持高并发度，成千上万个用户可同时操纵同一个数据库。Berkeley DB能以足够小的空间占用量运行于有严格约束的嵌入式系统。
　　Berkeley DB在嵌入式应用中比关系数据库和面向对象数据库要好，有以下两点原因：
　　（1）因为数据库程序库同应用程序在相同的地址空间中运行，所以数据库操作不需要进程间的通讯。在一台机器的不同进程间或在网络中不同机器间进行进程通讯所花费的开销，要远远大于函数调用的开销；
　　（2）因为Berkeley DB对所有操作都使用一组API接口，因此不需要对某种查询语言进行解析，也不用生成执行计划，大大提高了运行效。

嵌入式网络数据库系统的特点：

无需解析SQL语句
支持更多的SQL操作
客户端小

## db api nosql
# 开源  fuzai junhen
nginx
sharejdbc
mycat
分库分表uid key+dtkey

# 优化效率

## add idx 







## enhs perf couchdb mgdb rds
index enginer(store as mgdb)

## chache 
read cache mybatis rds  mgdb
write cache rds mq

