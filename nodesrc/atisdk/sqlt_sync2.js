const sqlite3 = require("sqlite3").verbose();

// sqlite3 does not support async/await then you need to create an async function with a promise like this e.x.

//  if not exist table table

exports.run = function run(sql, dbfile) {
  return new Promise((resolve, reject) => {
    db1350 = new sqlite3.Database(dbfile);
    db1350.run(sql, [], (e, rsz) => {
      if (e) reject(e);

      //  console.log(111);
      resolve(db1350);
    });
  });
};

exports.all = function all(sql, dbfile) {
  return new Promise((resolve, reject) => {
    db1350 = new sqlite3.Database(dbfile);
    db1350.all(sql, [], (e, rows) => {
      if (e) reject(e);

      resolve(rows);
    });
  });
};
//function

// (async () => {

//   const dbfile = "user_1883_dbf.db";

//   await run("create table  userinfo(c JSON)", dbfile);
// console.log(111)

//   o = { dt:2022,evt:"meet ",time:new Date().toLocaleTimeString() };
//   sql = " insert into userinfo values('" + JSON.stringify(o) + "') ";
//   await run(sql,dbfile);
//   console.log("after inst dt")

// })();

// C:\Users\tom\AppData\Roaming\npm\pkg.cmd -t win sqlt_sync.js
