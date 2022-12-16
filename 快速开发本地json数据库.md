快速开发本地json数据库

<!-- TOC -->

- [LowDB 是一个小型的本地JSON 数据库](#lowdb-是一个小型的本地json-数据库)
- [node-little-db 小型本地json文件数据库](#node-little-db-小型本地json文件数据库)

<!-- /TOC -->

小型本地Json 数据库- Node.JS 下LowDB 的使用


# LowDB 是一个小型的本地JSON 数据库
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

Lowdb不支持Node的集群模块。

如果你有大的JavaScript对象（），你可能会遇到一些性能问题。这是因为无论何时调用，整个都会使用序列化并写入存储。~10-100MBdb.writedb.dataJSON.stringify

根据您的用例，这可能很好，也可以没问题。可以通过执行批处理操作并仅在需要时调用来缓解它。db.write

如果您打算扩展，强烈建议使用PostgreSQL或MongoDB等数据库。

什么是Lowdb
lowdb是一个本地的json文件数据库，简单来说就是用一个json文件来充当数据库，来实现增删改查这些数据库的基本的功能。 lowdb具有如下优点：


官方文档中推荐lowdb的文件大小不超过100MB,因为在js中，格式化json主要用JSON.parse()和JSON.stringify,当超过100MB之后会有无法避免的性能问题。还有如果你使用localStorage，
限制应该是5MB。这也是我一开就说应用于小型服务的原因。

 

#  node-little-db 小型本地json文件数据库
node-little-db小型本地json文件数据库
Tiny local JSON database for Node and Electron
小型项目的小型本地 JSON 数据库

特点： node-little-db 小型本地json文件数据库，你不需要学习其他API，就像操作一个对象、数组一样操作它即可。
————————————————
 