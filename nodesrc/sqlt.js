const sqlite3 = require("sqlite3").verbose();

let db = new sqlite3.Database("db887.db");

//  if not exist table table

db.run(" create table  col_tab(docx JSON)", [], (e, rsz) => {
  console.log(e);
  console.log(111);

  o = { id: "19", name: "Lida" };
  sql = " insert into col_tab values('" + JSON.stringify(o) + "') ";
  db.run(sql);

  sql = "SELECT json_extract(docx,'$.name') as c1 FROM col_tab;";
  db.all(sql, [], (err, rows) => {
    if (err) {
      throw err;
    }
    rows.forEach((row) => {
      console.log(row);
    });
  });
});

//db.close();
