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
import com.mongodb.util.JSON;
 

public class mgdbUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="mongodb://localhost:27017";
int idx=s.lastIndexOf(":");
System.out.println(s.substring(0, idx));
System.out.println(s.substring(idx+1));
 	
	Properties e=getPropObjFrmSprbt();
	MongoClient mongoClient = getMongoClient(e);
	
	 //连接到数据库 query
	String db = e.getProperty("mongoconfig.dbName");
 
	MongoCollection<Document> collection =  mongoClient.getDatabase(db).getCollection("user");
 
	FindIterable<Document> documents = collection.find();
	for (Document document : documents) {
	    System.out.println(document);
	    System.out.println(document.toJson());
	    System.out.println(com.alibaba.fastjson.JSON.toJSON(e));
	}

	System.out.println(collection);
	 System.out.println( com.alibaba.fastjson.JSON.toJSON(documents));
	 Properties props = getPropObjFrmSprbt();
   
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
	
	
	public static MongoClient getMongoClient(Properties environment) {
        String url = environment.getProperty("mongoconfig.uri");
        int idx_host=url.indexOf("//")+2;
        int idx=url.lastIndexOf(":");

        String host = url.substring(idx_host, idx);
		ServerAddress serverAddress = new ServerAddress(host,  Integer.parseInt(url.substring(idx+1)) );
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);
        
      //  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential(environment.getProperty("mongoconfig.username")  , environment.getProperty("mongoconfig.dbName"), environment.getProperty("mongoconfig.password").toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        if( environment.getProperty("mongoconfig.password").trim().equals("") )
        {
        	
        	 MongoClient mongoClient = new MongoClient(addrs);
             return mongoClient;
        }else
        {
       	 MongoClient mongoClient = new MongoClient(addrs,credentials);
         return mongoClient;
        }
       
        
     
    }

}
