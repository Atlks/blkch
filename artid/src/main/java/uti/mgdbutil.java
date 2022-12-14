package uti;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bson.Document;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat.Column;
import com.alibaba.druid.stat.TableStat.Condition;
import com.alibaba.druid.util.JdbcConstants;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;

import pkg1.mgdbUtil;

public class mgdbutil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Deprecated
	public static Document toQry(String sqlCdt) {

		sqlCdt = " select * from db1.tb1 where  " + sqlCdt;
		DbType dbType = JdbcConstants.MYSQL;
		// 格式化输出
		String result = SQLUtils.format(sqlCdt, JdbcConstants.MYSQL);
		System.out.println(result); // 缺省大写格式
		List<SQLStatement> stmtList = SQLUtils.parseStatements(sqlCdt, dbType);
		SQLStatement stmt = stmtList.get(0);
		MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
		stmt.accept(visitor);
		// 获取表名称
		System.out.println("table names:");
		// visitor.getOriginalTables() // [imapi.user]
		//
		String db2 = visitor.getRepository().getDefaultSchemaName();
		String table = visitor.getOriginalTables().get(0).getSimpleName();
		// System.out.println( visitor.getTables().get(0) );
		// visitor.get
		// Map<Name, TableStat> tabmap = visitor.getTables();
		List<Condition> li = visitor.getConditions();
		for (Condition condition : li) {
			String colname = condition.getColumn().getName();
			String op = condition.getOperator();
			String val = condition.getValues().get(0).toString();
			if (op.toLowerCase().equals("like")) {
				val = val.replaceAll("%", "");
				Document regexQuery = whereLikeQueryCondt(colname, val);
				System.out.println(regexQuery);
				return regexQuery;

			}
		}
		return new Document();
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
			System.out.println(addrs);
			MongoClient mongoClient = new MongoClient(addrs);
			return mongoClient;
		} else {
			MongoClient mongoClient = new MongoClient(addrs, credentials);
			return mongoClient;
		}

	}

	public static FindIterable<Document> qry(String sql, MongoClient mongoClient) {
	//	Document w = toQry(sql);

		sql = "  select *  " + sql;
		DbType dbType = JdbcConstants.MYSQL;
		// 格式化输出
		String result = SQLUtils.format(sql, JdbcConstants.MYSQL);
		System.out.println(result); // 缺省大写格式
		List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
		SQLStatement stmt = stmtList.get(0);
		MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
		stmt.accept(visitor);
		// 获取表名称
		System.out.println("table names:");
		// visitor.getOriginalTables() // [imapi.user]
		//
		String db2 = visitor.getRepository().getDefaultSchemaName();
		String table = visitor.getOriginalTables().get(0).getSimpleName();
		Document whr = getWhr(visitor);
		Document sort=getSortDoc(visitor.getOrderByColumns());
		
	 
	   

		return mongoClient.getDatabase(db2).getCollection(table).find(whr).sort(sort);
	}

	public static Document getWhr(MySqlSchemaStatVisitor visitor) {
		List<Condition> li = visitor.getConditions();
		Document whr = new Document();
		for (Condition condition : li) {
			final String colname = condition.getColumn().getName();
			String op = condition.getOperator();
			final Object val = condition.getValues().get(0);
			if (op.toLowerCase().equals("like")) {
				String val2 = val.toString().replaceAll("%", "");
				whr = whereLikeQueryCondt(colname, val2);
				System.out.println(whr);

			}
			if (op.toLowerCase().equals("=")) {

				whr = new Document() {
					{
						put(colname, val);
					}
				};
				System.out.println(whr);

			}
		}
		return whr;
	}

	public static Document getSortDoc(List<Column> orderByColumns) {
		if(orderByColumns.size()==0)
			return new Document();
		List<Column> li_odrby=	orderByColumns;
		Column OrderCol=li_odrby.get(0);
		final String ordCol=OrderCol.getName();
		  String ordtype= OrderCol.getAttributes().get("orderBy.type").toString();
		if(ordtype.equals("DESC"))
		return new Document() {{
			put(ordCol,-1);
		}};
		else {
			return new Document() {{
				put(ordCol,1);
			}};
		}
	}

	public static Document toWhrDoc(String sql_cdt) {

		sql_cdt = "  select *  from db.tab " + sql_cdt;
		DbType dbType = JdbcConstants.MYSQL;
		// 格式化输出
		String result = SQLUtils.format(sql_cdt, JdbcConstants.MYSQL);
		System.out.println(result); // 缺省大写格式
		List<SQLStatement> stmtList = SQLUtils.parseStatements(sql_cdt, dbType);
		SQLStatement stmt = stmtList.get(0);
		MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
		stmt.accept(visitor);
		// 获取表名称
		System.out.println("table names:");
		// visitor.getOriginalTables() // [imapi.user]
		//
		String db2 = visitor.getRepository().getDefaultSchemaName();
		String table = visitor.getOriginalTables().get(0).getSimpleName();
		// System.out.println( visitor.getTables().get(0) );
		// visitor.get
		// Map<Name, TableStat> tabmap = visitor.getTables();
		List<Condition> li = visitor.getConditions();
		for (Condition condition : li) {
			String colname = condition.getColumn().getName();
			String op = condition.getOperator();
			String val = condition.getValues().get(0).toString();
			if (op.toLowerCase().equals("like")) {
				val = val.replaceAll("%", "");
				Document regexQuery = whereLikeQueryCondt(colname, val);
				System.out.println(regexQuery);
				return regexQuery;

			}
		}
		return new Document();
	}

}
