ex api 增强api

# 提升可读性的
dsl 减少
使用fp 闭包提升可读性
减少语法噪音 长度50%比较好
static import

     new MongoClient("mongodb://localhost:27017").GetDatabase("db222").GetCollection<BsonDocument>("co1").InsertOne(bd);

     InsertOneX("mongodb://localhost:27017", "db222.col", bd);
      InsertOneX("mongodb://localhost:27017/db222.col", bd);



# 方便 debg的
log


# try cahtch 提升稳定性的

# 提升性能的
异步api

# 提升 