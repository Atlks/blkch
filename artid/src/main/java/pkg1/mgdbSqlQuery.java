package pkg1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.bson.Document;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

 
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.stat.TableStat.Condition;
import com.alibaba.druid.stat.TableStat.Name;
import com.alibaba.druid.util.JdbcConstants;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.util.JSON;

import uti.Util;
import uti.mgdbutil;

public class mgdbSqlQuery {

	public static void main(String[] args) {
		
		 Document whr ;
		 FindIterable<Document> rows;
		
//		// 构建MongoDB查询器
//		MongoDBQuerier dataQuerier = new MongoDBQuerier();
//		String[] serverIps = new String[] { "172.30.30.8" };
//		Properties properties = new Properties();
//		// 完成对MongoDB的连接
//		dataQuerier.connect(serverIps, properties);
//		// 输入SQL语句，返回二维结果集，类似与JDBC的ResultSet
//		RecordSet recordSet = dataQuerier.query("select w.dns, w.ip from mydb.web w where (w.port=443 or w.port=8080) and w.ip='127.0.0.1' or w.ip='127.0.0.2'");
//		// 打印输出
//		outputRecordSet(RecordSet recordSet)
		
		
		
      
     

		Properties e = getPropObjFrmSprbt();
		MongoClient mongoClient = getMongoClient(e);

		// -------------------连接到数据库 query
		String db = e.getProperty("mongoconfig.dbName");
		FindIterable<Document> documents = mongoClient.getDatabase(db).getCollection("user").find().limit(999);
		documents=documents.limit(999);
		// where query
		 String sql="from imapi.user where _id=888";
		 sql="from imapi.user where nickname='888' order by  creatTime desc";
		 sql="from imapi.user where   _id=88 order by  creatTime desc";
		 rows=mgdbutil.qry(sql,mongoClient);
//		  = mongoClient.getDatabase(db).getCollection("user").find(new Document() {{
//			put("nickname", "888");
//		}});

		// -------like query
		 String sql_cdt="nickname like '公众' ";
		Document regexQuery = mgdbutil.toQry(sql_cdt);

	//	documents = mongoClient.getDatabase(db).getCollection("user").find(regexQuery).limit(999);

		for (Document document : rows) {
			// System.out.println(document);
			System.out.println(document.get("name"));
			System.out.println(document.toJson());
			// System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
		}

		// System.out.println(collection);
		System.out.println(com.alibaba.fastjson.JSON.toJSON(documents));
		Properties props = getPropObjFrmSprbt();

	 
	//	consoleQueryFollow(888, 0, 0);

	//	addIndexUniq();

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
		//mongoClient.getDatabase("u_friends").getCollection("0").insertOne(d);

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
					mgdbSqlQuery.class.getClassLoader().getResourceAsStream("application.properties"),
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
           System.out.println(addrs);
			MongoClient mongoClient = new MongoClient(addrs);
			return mongoClient;
		} else {
			MongoClient mongoClient = new MongoClient(addrs, credentials);
			return mongoClient;
		}

	}

}
