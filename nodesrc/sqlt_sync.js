const sqlite3 = require("sqlite3").verbose();



//  if not exist table table

function run(sql, dbfile) {

  return new Promise(
    (resolve, reject) => {

      db1350 = new sqlite3.Database(dbfile);
      db1350.run(sql, [], (e, rsz) => {
        console.log(e);
        //  console.log(111);
        resolve(db1350);

      })



    });
}
//function 


(async () => {

  const dbfile = "user_1157_dbf.db";

  //---------create table
  db = await run("create table  userinfo(c JSON)", dbfile)
  console.log("after crt tabl");


  // --------- insert dt
 
// 2014年6月18日 上午10:33:24 
  o = { dt:2022,evt:"meet ",time:new Date().toLocaleTimeString() };
  sql = " insert into userinfo values('" + JSON.stringify(o) + "') ";
  await run(sql, dbfile);
  console.log("after inst dt")



  //----search query
  sql = "SELECT json_extract(c,'$.time') as c1 FROM userinfo;";
  console.log(sql)
  db = new sqlite3.Database(dbfile);
  db.all(sql, [], (err, rows) => {
    console.log(err)
    rows.forEach((row) => {
      console.log(row);
    });
  });

})();

// C:\Users\tom\AppData\Roaming\npm\pkg.cmd -t win sqlt_sync.js






