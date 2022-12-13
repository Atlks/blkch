mgdb mng 

个问题说明一件事儿，我们连接数据库没有连接上，为什么连接不上呢，比如我们用mongoDB下面的一个database叫做xiaomu，但是我们的用户名密码是一个database叫做admin下的用户，这样就连不上了。因此，我们在database为xiaomu下面建立一个用户，然后用这个用户进行登录即可。

1.打开mongoDB数据库，并进入xiaomu数据库

use xiaomu

2.添加一个用户
db.createUser(
     {
       user: "wenqiang",
       pwd: "1438438",
       roles: ["readWrite"]
     }
)

3.登录用户，并测试是否好用

db.auth("mutianwei", "123568")

db.createCollection("logs")

db.logs.insert( { name: "wangwenqiang", age: 3} )

db.logs.find()
————————————————
版权声明：本文为CSDN博主「小木希望学园」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u013631121/article/details/81089971