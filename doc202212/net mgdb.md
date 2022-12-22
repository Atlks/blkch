net mgdb
Mongodb是用Json保存的,因此也可以直接用Json格式插入,可用BsonDocument对象作为泛型对象。

Mongodb是用Json保存的,因此也可以直接用Json格式插入,可用BsonDocument对象作为泛型对象。

var json = "{id:1,name:'xx学校',address:'xxx路xx号',remarks:'暂无！'}";
BsonDocument bsons = BsonDocument.Parse(json);


# add


BsonDocument bd=new BsonDocument();
            bd.Add("a", 1);
     new MongoClient("mongodb://localhost:27017").GetDatabase("db222").GetCollection<BsonDocument>("co1").InsertOne(bd);

     InsertOneX("mongodb://localhost:27017", "db222.col", bd);
      InsertOneX("mongodb://localhost:27017/db222.col", bd);
## where qry
我们安装的NuGet包是支持Lamda表达式的,可用条件表达式来查找数据

//拿到集合(表)
IMongoCollection<Student> student = db.GetCollection<Student>("Student");
var data = Builders<Student>.Filter.Where(m => m.age > 21 && m.name.Contains("江"));
var result = student.Find(data).ToList();



# sort
      IMongoCollection<Student> student = db.GetCollection<Student>("Student");
var filter = Builders<Student>.Filter.Where(m => m.age > 21);
FindOptions<Student, Student> findOpt = new FindOptions<Student, Student>();
findOpt.Limit = 2;
findOpt.Skip = 1;
findOpt.Sort = Builders<Student>.Sort.Ascending(m => m.age).Descending(m => m.name);
var result = (student.FindAsync(filter, findOpt).Result).ToList();
java

	mongoClient.getDatabase(frd_db).getCollection(frdColName).insertOne(d);


