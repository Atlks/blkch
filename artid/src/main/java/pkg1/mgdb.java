package pkg1;

 
	
 

	import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
	import org.bson.Document;

	public class mgdb {
	    public static void main(String[] args) {
	        // 连接到 mongodb 服务
	        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

	        // 连接到数据库
	        MongoDatabase mongoDatabase = mongoClient.getDatabase("db7");

	    //    mongoDatabase.createCollection("col1_tab1");



	        MongoCollection<Document> collection = mongoDatabase.getCollection("col1_tab1");
	        System.out.println("集合 test 选择成功");
	        //插入文档
	        /**
	         * 1. 创建文档 org.bson.Document 参数为key-value的格式
	         * 2. 创建文档集合List<Document>
	         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
	         * */
	        Document document = new Document("title", "ttttt").
	                append("description", "ddddsc").
	                append("likes", 100).
	                append("by", "Fly");

	        collection.insertOne(document);
	        System.out.println("fff");
	    }
	}


 
