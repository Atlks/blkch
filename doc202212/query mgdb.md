query mgdb


ori driver query trouble by where cdtion is

NoSQL在日常项目中的使用越来越普遍，尤其以mongoDB为甚。而java开发我们最常使用的框架非spring系列莫属。 因此本文主要介绍如何使用如何使用MongoTemplate进行查询，本文不包含如何使用spring-data-monog中的MongoRepository进行查询，MongoRepository会在其他博文中介绍。

我们可以直接在服务中使用MongoTemplate， 然后依据业务在controller’、或者其他地方调用查询，本文为了简单起见，直接在controller中调用MongoTemplate的查询方法。
————————————————
版权声明：本文为CSDN博主「russle」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/russle/article/details/80373560