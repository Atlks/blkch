dev efk api qry lan api查询语言dsl GraphQL

<!-- TOC -->

- [couchdb 支持rest接口 N1QL 查询](#couchdb-支持rest接口-n1ql-查询)
- [sql 可以挂在nosql上 mgdb rds](#sql-可以挂在nosql上-mgdb-rds)
- [graphql](#graphql)
- [js](#js)
- [html xml 查询](#html-xml-查询)
- [json查询](#json查询)
- [es dsl](#es-dsl)
- [mgdb 有dsl单驱动不支持](#mgdb-有dsl单驱动不支持)
- [qry json use lowdb apiEx](#qry-json-use-lowdb-apiex)
  - [LowDB 是一个小型的本地JSON 数据库](#lowdb-是一个小型的本地json-数据库)
- [RaptorDB](#raptordb)

<!-- /TOC -->


# couchdb 支持rest接口 N1QL 查询

N1QL REST API
概述
查询服务 REST API 由查询服务提供。 通过此接口，您可以运行 N1QL 查询并设置请求级参数。

API 方案和主机 URL 如下所示：

curl -v http://localhost:8093/query/service \
     -d 'statement=SELECT name FROM `travel-sample`.inventory.hotel LIMIT 1' \
     -u Administrator:password

其中 是运行查询服务的节点的主机名或 IP 地址。node

curl -v http://localhost:8093/query/service?statement=SELECT%20name%20FROM%20%60travel-sample%60.inventory.hotel%20LIMIT%201%3B \
     -u Administrator:password


CouchDB不错的

couchdb 60M...mgdb need 280M...
# sql 可以挂在nosql上 mgdb rds
早mgdb上
，使用druid解析即可。。

# graphql

 graphql GraphQL 既是一种用于 API 的查询语言也是一个满足你数据查询的运行时。GraphQL 对你的 API 中的数据提供了一套易于理解的完整描述，使得客户端能够准确地获得它需要的数据，而且没有任何冗余，也让 

 # js
 多年来，数据库软件公司 Couchbase 一直在寻找查询一般文档的最佳方式。一开始，查询是作为一个 JavaScript 函数编写的，然后交给数据库执行

 # html xml 查询
 # json查询

 # es dsl

 # mgdb 有dsl单驱动不支持

 rds 没有dsl

 # qry json use lowdb apiEx
 
## LowDB 是一个小型的本地JSON 数据库
crazykid.moe
https://blog.crazykid.moe › article › nodejs-lowdb
2018年12月27日 — LowDB 是一个小型的本地JSON 数据库，可以省去连接sql 数据库的麻烦，数据直接保存在本地json 文件里。
Lowdb是轻量化的基于Node的JSON文件数据库。对于构建不依赖服务器的小型项目，使用LowDB存储和管理数据是非常不错的选择。

运行后 db.json 数据代码如下所示：

{"posts":[{"id":1,"title":"welcome to hangzhou"}],"user":{"name":"kongzhi"},"count":31}
注意：由于我们的 lowdb 基于 lodash 的，因此我们可以使用 lodash 中的所有方法和属性

数据直接存储为json文件没有压缩

// 查找数据
const value = db.get('posts').find({'id': 1}).value();
console.log(value);



# RaptorDB


    RaptorDB是一个非常小型的快速嵌入式NoSQL数据库，它使用b+tree或者MurMur哈希索引。最初的设计是用来存储JSON数据，但是目前可以存储任何类型的数据。