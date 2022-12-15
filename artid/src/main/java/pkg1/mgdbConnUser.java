package pkg1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;

import uti.mgdbutil;

public class mgdbConnUser {
	
	public static void main(String[] args) {

		Properties e=getPropObjFrmSprbt();
			String url = e.getProperty("mongoconfig.uri");
			int idx_host = url.indexOf("//") + 2;
			int idx = url.lastIndexOf(":");

			String host = url.substring(idx_host, idx);
			ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(url.substring(idx + 1)));
			List<ServerAddress> addrs = new ArrayList<ServerAddress>();
			addrs.add(serverAddress);

			// MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

			// MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
			MongoCredential credential = MongoCredential.createCredential("user01",
 				e.getProperty("mongoconfig.dbName"),"pwd123".toCharArray());
		 
			List<MongoCredential> credentials = new ArrayList<MongoCredential>();
			credentials.add(credential);

			// return new MongoClient(addrs,credentials);

			// 通过连接认证获取MongoDB连接
			MongoClient mongoClient = new MongoClient(addrs, credentials);
			 FindIterable<Document> rows=	mongoClient.getDatabase("imapi").getCollection("user").find( ).limit(5);

		 
			for (Document document : rows) {
			 
				System.out.println(document.toJson());
				// System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
			}

			
System.out.println(mongoClient);
		 
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

}
