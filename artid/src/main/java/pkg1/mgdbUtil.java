package pkg1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bson.Document;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.util.JSON;

import uti.Util;

public class mgdbUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mongodb://localhost:27017";
		int idx = s.lastIndexOf(":");
		System.out.println(s.substring(0, idx));
		System.out.println(s.substring(idx + 1));

		Properties e = getPropObjFrmSprbt();
		MongoClient mongoClient = getMongoClient(e);

		// -------------------连接到数据库 query
		String db = e.getProperty("mongoconfig.dbName");
		FindIterable<Document> documents = mongoClient.getDatabase(db).getCollection("user").find();

		// where query
		Document whereQuery = new Document();
		whereQuery.put("nickname", "88");
		documents = mongoClient.getDatabase(db).getCollection("user").find(whereQuery);

		// -------like query
		Document regexQuery = whereLikeQueryCondt("nickname", "公众");

		documents = mongoClient.getDatabase(db).getCollection("user").find(regexQuery);

		for (Document document : documents) {
			// System.out.println(document);
			System.out.println(document.get("name"));
			System.out.println(document.toJson());
			// System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
		}

		// System.out.println(collection);
		System.out.println(com.alibaba.fastjson.JSON.toJSON(documents));
		Properties props = getPropObjFrmSprbt();

		// query
		String uid = "888";
		String addids = "10000002,1100,10000";
		String[] ids = addids.split(",");
//		for (String add_id : ids) {
//			Document d = new Document();
//			d.put("userId", uid);
//			d.put("toUserId", add_id);
//			Document where =   new Document();
//			where.put("_id", Integer.parseInt(add_id) );
//			Document frd = mongoClient.getDatabase(db).getCollection("user")
//					.find(where).first();
//           System.out.println(frd);
//			d.put("addFrd", frd);
//			d.put("toNickname", frd.get("nickname"));
//			mongoClient.getDatabase(db).getCollection("u_friends").insertOne(d);
//
//		}

		consoleQueryFollow(888, 0, 0);

		addIndexUniq();

	}

	private static void addIndexUniq() {

		String uid = "888";
		String add_id = "88890";
		Properties evn = uti.Util.getPropObjFrmSprbt();
		MongoClient mongoClient = Util.getMongoClient(evn);
		String db = evn.getProperty("mongoconfig.dbName");
		Document d = new Document();

		d.put("userId", Integer.parseInt(uid));

		d.put("toUserId", Integer.parseInt(add_id));
		Document where = new Document();
		where.put("_id", Integer.parseInt(add_id));
		Document frd = mongoClient.getDatabase(db).getCollection("user").find(where).first();
		System.out.println(frd);
		d.put("addFrd", frd);
		d.put("status", 8);
		d.put("toNickname", frd.get("nickname"));
		 
		mongoClient.getDatabase("u_friends").getCollection("0").createIndex(Indexes.ascending("userId", "toUserId"), new IndexOptions().unique(true));
		mongoClient.getDatabase("u_friends").getCollection("0").insertOne(d);

	}

	public static void consoleQueryFollow(int userId, int toUserId, int status) {

		/**
		 * 分库分表
		 */

		Document where = new Document("userId", userId).append("status", new Document(MongoOperator.NE, 0))
				.append("toUserId", new Document(MongoOperator.GT, 10100));
		// where = new Document("userId",userId);
		System.out.println(where);
		Properties e = getPropObjFrmSprbt();
		MongoClient mongoClient = getMongoClient(e);
		String db = e.getProperty("mongoconfig.dbName");
		FindIterable<Document> documents = mongoClient.getDatabase(db).getCollection("u_friends").find(where);

		for (Document document : documents) {
			// System.out.println(document);
			System.out.println(document.get("name"));
			System.out.println(document.toJson());
			// System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
		}
	}

	public static Document whereLikeQueryCondt(String key, String value) {
		Document regexQuery = new Document();
//		String value = "88";
//		String key = "nickname";
		regexQuery.put(key, new Document("$regex", value).append("$options", "i"));
		System.out.println(regexQuery.toString());// Document{{nickname=Document{{$regex=88, $options=i}}}}
		return regexQuery;
	}

	public static Properties getPropObjFrmSprbt() {
		Properties props = new Properties();
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					mgdbUtil.class.getClassLoader().getResourceAsStream("application.properties"),
					StandardCharsets.UTF_8);
			props.load(inputStreamReader);
		} catch (IOException e1) {
			System.out.println(e1);
		}
		return props;
	}

	public static MongoClient getMongoClient(Properties e) {
		String url = e.getProperty("mongoconfig.uri");
		int idx_host = url.indexOf("//") + 2;
		int idx = url.lastIndexOf(":");

		String host = url.substring(idx_host, idx);
		ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(url.substring(idx + 1)));
		List<ServerAddress> addrs = new ArrayList<ServerAddress>();
		addrs.add(serverAddress);

		// MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

		// MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
		MongoCredential credential = MongoCredential.createCredential(e.getProperty("mongoconfig.username"),
				e.getProperty("mongoconfig.dbName"), e.getProperty("mongoconfig.password").toCharArray());
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(credential);

		// return new MongoClient(addrs,credentials);

		// 通过连接认证获取MongoDB连接
		if (e.getProperty("mongoconfig.password").trim().equals("")) {

			MongoClient mongoClient = new MongoClient(addrs);
			return mongoClient;
		} else {
			MongoClient mongoClient = new MongoClient(addrs, credentials);
			return mongoClient;
		}

	}

}
