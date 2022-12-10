// request = require('request');
request = require('sync-request'); 
async = require('async');
task=[];

url = "http://localhost:5000/friendGroup/add?access_token=tk888&groupName=grp13478&salt=1669893571254&secret=xxUYkpr"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));
 
console.log(1111111111111111111111)
throw 111;

url="http://localhost:5000/friendGroup/updateGroupUserList?access_token=tk888&groupId=g155&userIdListStr=10000032%2c10000033&salt=1669893579434&secret=Y9ryiOppTWHcQpRvSI4m1w%3d%3d"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));


 








url="http://localhost:5000/friendGroup/list?access_token=tk888&secret=x"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));
console.log(2222222)


//http://localhost:5000/friendGroup/update?access_token=7a617dd3fd7640c5880964f37ecf4998&groupId=50ab23fd-7201-11ed-975d-d8bbc1&groupName=%ef%bd%87%ef%bc%92%ef%bc%92%ef%bc%93%ef%bc%93&salt=166989400874
url="http://localhost:5000/friendGroup/update?access_token=tk888&&groupId=50ab23fd-7201-11ed-975d-d8bbc1&groupName=grp1337&secret=x"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));
console.log(2222222)


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
