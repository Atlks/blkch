asyn to sync meth

# use sync library
request = require('sync-request'); 
async = require('async');
task=[];


url = "http://localhost:5000/friendGroup/add?access_token=tk888&groupName=grp999&salt=1669893571254&secret=xxUYkpr"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));

## await wrap

## async lib bhaoyon
var async = require("async");

async.series([

    use sleep..



    Using the Sleep Command
You can use execSync to invoke your OS' sleep command.

const {execSync} = require('child_process');

execSync('sleep 1'); // block process for 1 second.

// window no sleep .timeout
const {execSync} = require('child_process');

execSync('timeout /T 3'); // block process for 1 second.
