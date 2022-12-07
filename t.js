// request = require('request');
request = require('sync-request'); 
async = require('async');
task=[];


url = "http://localhost:5000/friendGroup/add?access_token=tk888&groupName=grp999&salt=1669893571254&secret=xxUYkpr"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));
 
console.log(1111111111111111111111)

url = "http://localhost:5000/friendGroup/delete?access_token=tk888&groupName=grp999&salt=1669893571254&secret=xxUYkpr"
console.log(url) 
 res = request('get', url,{});
console.log( (res.getBody('utf8')));

/**
 * 
 * 
 * ***************************************predepre 
 */
task.push(function(){

    url = "http://localhost:5000/friendGroup/add?access_token=tk888&groupName=grp999&salt=1669893571254&secret=xxUYkpr"

    request(url, { json: false }, (err, res, body) => {
        console.log(url);
      if (err) { 
          return console.log(err); 
      }
    
      // console.log(res);
      console.log(body);
     
    });


})



//  const {execSync} = require('child_process');

// //execSync('timeout /T 3'); // block process for 1 second.
// try{
//  //   execSync('waitfor SomethingThatIsNeverHappening /t 3'); // block process for 1 second.
//  execSync('  PING 1.1.1.1 -n 3 ')

// }catch(e){}

task.push(function(){


    url = "http://localhost:5000/friendGroup/delete?access_token=tk888&groupName=grp999&salt=1669893571254&secret=xxUYkpr"
    request = require('request');
    
    request(url, { json: false }, (err, res, body) => {
        console.log(url);
      if (err) { 
          return console.log(err); 
      }
    
      // console.log(res);
      console.log(body);
     
    });

})
//async.series(task,function(){})
//async.waterfall(task,function(){})
