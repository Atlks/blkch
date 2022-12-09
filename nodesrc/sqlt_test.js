const sqlite3 = require("sqlite3").verbose();
var mod1 = require("./atisdk/sqlt_sync");

(async () => {
  const dbfile = "user_1889_dbf.db";

  //--------------create table
  try {
    await mod1.run("create table  userinfo(c JSON)", dbfile);
  } catch (error) {
    console.log(error);
  }

  console.log(111);

  //---------------------------insert
  o = { dt: 2022, evt: "meet ", time: new Date().toLocaleTimeString() };
  sql = " insert into userinfo values('" + JSON.stringify(o) + "') ";
  await mod1.run(sql, dbfile);
  console.log("after inst dt");

  //----search query
  sql = "SELECT json_extract(c,'$.time') as c1 FROM userinfo;";
  console.log(sql);
  rows = await mod1.all(sql, dbfile);
  console.log(rows);
})();
