大数据量下分表模式  按照uid分表

tb

全局表,,uid,表路径对应


表路径对应
ip>port实例>db>tb name

mariadb,每个表是单独的文件。的。

分库后join问题。
使用子查询模式 代码join

使用零时表mode..

表的存储可以使用json文件模式，每个记录一个json
表的索引使用sqlite模式。。
表的存储也可sqlite 分表来做。。
分表更加方便，按照每个用户key文件来自动化来分表。。