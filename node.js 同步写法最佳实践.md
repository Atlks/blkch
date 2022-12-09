node.js 同步写法最佳实践


# mongodb驱动已经支持await了。。
# rds的同步支持
# http可以使用sync-request类库
# mysql ？？
# sqilte3还不支持，已经2022.12了。。单可以使用util。Promis来转换使用


const dbfile = "user_1923_dbf.db";
db = new sqlite3.Database(dbfile);
db.run = util.promisify(db.run);
db.all = util.promisify(db.all);

 await db.run("create table  userinfo(c JSON)");


 
  // 2014年6月18日 上午10:33:24
  o = { dt: 2022, evt: "meet ", time: new Date().toLocaleTimeString() };
  sql = " insert into userinfo values('" + JSON.stringify(o) + "') ";
  await db.run(sql);
  console.log("after inst dt");

  //----search query
  sql = "SELECT json_extract(c,'$.time') as c1 FROM userinfo;";
  console.log(sql);
  rows = await db.all(sql);
  console.log(rows);
})();