package pkg1;

import java.util.Properties;

import org.bson.Document;

import com.github.vincentrussell.query.mongodb.sql.converter.MongoDBQueryHolder;
import com.github.vincentrussell.query.mongodb.sql.converter.ParseException;
import com.github.vincentrussell.query.mongodb.sql.converter.QueryConverter;
 
import com.mongodb.client.FindIterable;
import com.mongodb.MongoClient;
 
 

public class sql2mgdb {

	public static void main(String[] args) throws Exception {
		QueryConverter queryConverter = new QueryConverter.Builder().sqlString("select * from user where nickname like '%9%'" ).build();
		MongoDBQueryHolder mongoDBQueryHolder = queryConverter.getMongoQuery();
		String collection = mongoDBQueryHolder.getCollection();
		Document query = mongoDBQueryHolder.getQuery();
		
		Properties e =mgdbUtil. getPropObjFrmSprbt();
		MongoClient mongoClient =  mgdbUtil. getMongoClient(e);

		// -------------------连接到数据库 query
		String db = e.getProperty("mongoconfig.dbName");
		FindIterable<Document> documents = mongoClient.getDatabase(db).getCollection("user").find();

		// where query
 
		documents = mongoClient.getDatabase(db).getCollection("user").find(query);

		// -------like query
//		Document regexQuery = mgdbUtil.whereLikeQueryCondt("nickname", "公众");
//
//		documents = mongoClient.getDatabase(db).getCollection("user").find(regexQuery);

		for (Document document : documents) {
			// System.out.println(document);
			System.out.println(document.get("name"));
			System.out.println(document.toJson());
			// System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
		}
		
		Document projection = mongoDBQueryHolder.getProjection();
		Document sort = mongoDBQueryHolder.getSort();

	}

}
