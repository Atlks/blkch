
//  npm install mongodb





(async () => {



    function connx(url) {

        return new Promise(
            (resolve, reject) => {
                var MongoClient_cls = require('mongodb').MongoClient;
                MongoClient_cls.connect(url, (err, MongoClient_conn) => {
                    // console.log(MongoClient_conn)
                    resolve(MongoClient_conn);

                })



            });
    }
    MongoClient_conn = await connx('mongodb://localhost:27017/runoob');


    myobj = { title: 'Back to the Future' };


    MongoClient_conn.db('db888').collection('col1_table1').insertOne(myobj, function (err, res) {

        console.log("文档插入成功");

    });
    MongoClient_conn.db('db999').collection('col1_table1').insertOne(myobj, function (err, res) {

        console.log("文档插入成功");

    });

    console.log("文档插入成功2");


})();
