activemq安装很简单。。

rckmq比较麻烦些。。

mqnamesrv.cmd   ，，和  mqbroker.cmd 设置环境变量 ROCKETMQ_HOME

和java_home


然后启动


RocketMQ 官方文档中并未提到可视化管理控制台（Console）的任何信息，因为官方发布版本中并未集成 Console 相关功能，不过在 GitHub 中可以找到一个 RocketMQ 的扩展项目 rocketmq-externals，其中包括 RocketMQ-Console，这个 RocketMQ 扩展项目由社区贡献和维护。
RocketMQ-Console 使用 Spring Boot 1.x 开发，本文介绍如何安装和运行 RocketMQ-Console。



RocketMQ Dashboard
Notice: Console has renamed to dashboard and transfered the new repo, it will graduate in the near future, and welcome you to fill in the user due diligence.



Run with source code
Prerequisite
64bit OS, Linux/Unix/Mac is recommended;
64bit JDK 1.8+;
Maven 3.2.x;
Maven spring-boot run
mvn spring-boot:run
or

Maven build and run
mvn clean package -Dmaven.test.skip=true
java -jar target/rocketmq-dashboard-1.0.1-SNAPSHOT.jar


cd  
D:\rocketmq-dashboard-master
D:\rocketmq-dashboard-master\mvn-start.txt.bat


set java_home=C:\Program Files (x86)\Java\jdk1.8.0_73
"C:\Users\tom\AppData\Local\JetBrains\IntelliJ IDEA 2022.2.4\plugins\maven\lib\maven3\bin\mvn.cmd" spring-boot:run


shunli boot ok...


D:\rocketmq-dashboard-master>"C:\Users\tom\AppData\Local\JetBrains\IntelliJ IDEA 2022.2.4\plugins\maven\lib\maven3\bin\mvn.cmd" spring-boot:run
[INFO] Scanning for projects...
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/apache/18/apache-18.pom


3 打开浏览器，输入 localhost:8080，可以看到如下界面
http://localhost:8080/#/topic




三、启动
# 启动namesvr，监听9876端口
nohup sh bin/mqnamesrv &
# 启动mqbroker，监听10911、10912端口
nohup sh bin/mqbroker -n localhost:9876 -c ./conf/broker.conf autoCreateTopicEnable=true &