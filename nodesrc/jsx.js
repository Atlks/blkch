
//  npm install mongodb

var MongoClient = require('mongodb').MongoClient;

// Replace the uri string with your connection string.
url = 'mongodb://localhost:27017/runoob';
 
MongoClient.connect(url,   (err, MongoClient_conn)=> {
    // console.log(MongoClient_conn)

    myobj = { title: 'Back to the Future' };


    MongoClient_conn.db('db000').collection('col1_table1').insertOne(myobj,   (err, res) =>{

        console.log("文档插入成功");

    });

    // console.log(movie);
});




