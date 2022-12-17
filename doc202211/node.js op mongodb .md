mongodb 是偏底层一点的插件，此处学习使用此插件是为了让大家了解连接 mongodb 的一些原理。在日常中，为了利于项目开发，通常使用 mongoose 插件

mongoose使用schemaer  ，，not good




//  npm install mongodb

var MongoClient = require('mongodb').MongoClient;

// Replace the uri string with your connection string.
url = 'mongodb://localhost:27017/runoob';
MongoClient.connect(url, function (err, MongoClient_conn) {
   // console.log(MongoClient_conn)

    myobj = { title: 'Back to the Future' };


    MongoClient_conn.db('db888').collection('col1_table1').insertOne(myobj, function (err, res) {

        console.log("文档插入成功");
        
    });

   // console.log(movie);
});




