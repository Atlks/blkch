
 var mod1 = require( "./atisdk/sqlt_sync");



(async () => {

    const dbfile = "user_1885_dbf.db";
   
    await mod1.run("create table  userinfo(c JSON)", dbfile);
  console.log(111)
  
    o = { dt:2022,evt:"meet ",time:new Date().toLocaleTimeString() };
    sql = " insert into userinfo values('" + JSON.stringify(o) + "') ";
    await mod1.run(sql,dbfile);
    console.log("after inst dt")
  
     
  })();