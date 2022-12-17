使用全文索引和like简化表设计 关联表 一对多多对多关系


select * from user_info where userid=100001

select * from user_info where match(grps) against(2);

select * from user_info where grps like '%1%'

可以不用建立关联表。。
