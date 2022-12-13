mgdb java exmp
<!-- TOC -->

- [query find()](#query-find)
  - [find().first() 获取第一条文档](#findfirst-获取第一条文档)
  - [使用find()对比查询find(whereQuery)  number = 5](#使用find对比查询findwherequery--number--5)
  - [.2 $in -  collection.find(inQuery); 获取number在2、4、5中的文档](#2-in----collectionfindinquery-获取number在245中的文档)
  - [2.3 $gt $lt - 获取5 \> number \> 2的文档](#23-gt-lt---获取5--number--2的文档)
  - [2.4 $ne - 获取number != 4的文档](#24-ne---获取number--4的文档)
- [3. 使用find()进行逻辑查询](#3-使用find进行逻辑查询)
  - [4. 使用find()通过正则表达式查询  模糊匹配](#4-使用find通过正则表达式查询--模糊匹配)

<!-- /TOC -->


# query find()
##  find().first() 获取第一条文档
1.1 获取第一条文档
Document document = collection.find().first();



Document fields = new Document();
fields.put("name", 1);

FindIterable<Document> projection = collection.find().projection(fields);



## 使用find()对比查询find(whereQuery)  number = 5
2.1 获取所有number = 5的文档
Document whereQuery = new Document();
whereQuery.put("number", 5);
FindIterable<Document> whereDocuments = collection.find(whereQuery);
MongoCursor<Document> whereIterator = whereDocuments.iterator();
while (whereIterator.hasNext()) {
    System.out.println(whereIterator.next());
}
输出：

{ "_id" : { "$oid" : "id"} , "number" : 5 , "name" : "mkyong-5"}
## .2 $in -  collection.find(inQuery); 获取number在2、4、5中的文档

Document inQuery = new Document();
List<Integer> list = new ArrayList<Integer>();
list.add(2);
list.add(4);
list.add(5);
inQuery.put("number", new Document("$in", list));
FindIterable<Document> listDocuments = collection.find(inQuery);

## 2.3 $gt $lt - 获取5 > number > 2的文档
Document gtQuery = new Document();
gtQuery.put("number", new Document("$gt", 2).append("$lt", 5));
FindIterable<Document> gtDocuments = collection.find(gtQuery);
MongoCursor<Document> gtIterator = gtDocuments.iterator();
while (gtIterator.hasNext()) {
    System.out.println(gtIterator.next());
}
输出：

{ "_id" : { "$oid" : "id"} , "number" : 3 , "name" : "mkyong-3"}
{ "_id" : { "$oid" : "id"} , "number" : 4 , "name" : "mkyong-4"}
## 2.4 $ne - 获取number != 4的文档

Document neQuery = new Document();
neQuery.put("number", new Document("$ne", 4));
FindIterable<Document> neDocuments = collection.find(neQuery);

# 3. 使用find()进行逻辑查询
3.1 $and - 获取number = 2 and name = 'mkyong-2'的文档

Document andQuery = new Document();

List<Document> obj = new ArrayList<Document>();
obj.add(new Document("number", 2));
obj.add(new Document("name", "mkyong-2"));
andQuery.put("$and", obj);

System.out.println(andQuery.toString());

FindIterable<Document> andDocuments = collection.find(andQuery);
MongoCursor<Document> andIterator = andDocuments.iterator();

## 4. 使用find()通过正则表达式查询  模糊匹配
4.1 $regex
Document regexQuery = new Document();
regexQuery.put("name",
        new Document("$regex", "Mky.*-[1-3]")
                .append("$options", "i"));

System.out.println(regexQuery.toString());

 