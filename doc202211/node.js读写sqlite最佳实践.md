node.js读写sqlite最佳实践


const sqlite3 = require("sqlite3");
const util = require("util");


const dbfile = "user_1923_dbf.db";
db = new sqlite3.Database(dbfile);
db.run = util.promisify(db.run);
db.all = util.promisify(db.all);


(async () => {
  //---------create table

  try {
    await db.run("create table  userinfo(c JSON)");
  }catch(err) {
    console.log(err);
  }
  console.log("after crt tabl");

  // --------- insert dt

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
