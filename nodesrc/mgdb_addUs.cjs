//  npm install mongodb
//  npm install mongodb

var MongoClient33 = require("mongodb").MongoClient;

(async () => {
  // Replace the uri string with your connection string.
  url = "mongodb://localhost:27017";

  MongoClient_conn = await MongoClient33.connect(url);
  int finish=88888 + 55;
  for (var i = 88888; i++; i <finish ) {
    myobj = { _id: i, nickname: "测试" + i };
    try {
      await MongoClient_conn.db("imapi").collection("user").insertOne(myobj);
    } catch (error) {
      console.log(error);
    }
    console.log(myobj);
  }
  MongoClient_conn.close();
})();
