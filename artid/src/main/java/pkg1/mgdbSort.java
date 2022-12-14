package pkg1;

import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

import uti.mgdbutil;

public class mgdbSort {

	public static void main(String[] args) {
		Properties e =mgdbutil. getPropObjFrmSprbt();
		MongoClient mongoClient =mgdbutil. getMongoClient(e);

		// -------------------连接到数据库 query
		String db = e.getProperty("mongoconfig.dbName");

		FindIterable<Document> documents = mongoClient.getDatabase(db).getCollection("userx").find()
				.sort(new Document() {
					{
						put("creatTime", -1);
					}
				});
		
		
		for (Document document : documents) {
			 
			System.out.println(document.toJson());
			// System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
		}

	}

}
