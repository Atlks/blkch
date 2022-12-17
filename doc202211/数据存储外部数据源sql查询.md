读取多层结构数据Json和XML是常用的多层结构数据。SQLite架构简单，又有Json计算能力，有时会承担Json文件/RESTful的计算功能，但SQLite不能直接解析Json文件/RESTful，需要用Java代码硬写，或借助第三方类库，最后再拼成insert语句插入数据表，代码非常繁琐，这里就不展示了。SPL架构同样简单，且可以直接解析Json文件/RESTful，可以大幅简化代码，比如：json(file("d:/xml/emp_orders.json").read()).select(Amount>2000 && Amount<=3000)
json(httpfile("http://127.0.0.1:6868/api/orders").read()).select(Amount>2000 && Amount<=3000)
SQLite没有XML计算能力，也不能直接解析XML文件/WebService，只能借助外部Java代码解析计算，非常繁琐。 SPL可以直接读取XML文件：

源计算SQLite的外部数据源只支持csv文件，跨源计算就是csv文件和库表间的关联、交集、子查询等计算。SQL是封闭的计算语言，不能直接计算库外数据，需要经过一个入库的过程，把csv文件变成库表之后才能进行跨源计算。参考前面的代码可知，入库的过程比较麻烦，不能只用SQL，还要借助Java或命令行。SPL开放性较好，可以直接计算多种数据源，数据源之间可以方便地进行跨源计算。比如csv和RESTful左关联：=join@1(json(httpfile("http://127.0.0.1:6868/api/orders").read()):o,SellerId; T("d:/Emp.csv"):e,EId)
写成

作者：哪吒学Java
链接：https://www.zhihu.com/question/31417262/answer/2615202415
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

外部数据源SQLite只支持文本数据文件，包括TAB分隔的txt、逗号分隔的csv，也可自定义其它分隔符。SPL支持多种数据源，包括：JDBC（即所有的RDB）csv、TXT、JSON、XML、ExcelHBase、HDFS、Hive、SparkRestful、WebService、WebcrawlElasticsearch、MongoDB、Kafka、R2dbc、FTPCassandra、DynamoDB、influxDB、Redis、SAP这些数据源都可以直接使用，非常方便。对于其他未列入的数据源，SPL也提供了接口规范，只要按规范输出为SPL的结构化数据对象，就可以进行后续计算。访问自有数据格式SQLite通过SQL访问库文件中的表，生成SQL结果集，即内存中的结构化数据对象。读取表时一般伴随着查询：select * from Orders where Amount>2000 and Amount<=3000
SPL通过SPL的T函数或import函数读取集文件，生成序表（相当于SQL结果集）。等价的代码：T("d:/Orders.btx").select(Amount>2000 && Amount<=3000)

简化管理数据管理