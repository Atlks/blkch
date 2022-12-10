asyn to sync meth

<!-- TOC -->

- [use sync library](#use-sync-library)
- [Node.js 内置的 util.Promise 包装法](#nodejs-内置的-utilpromise-包装法)
- [bluebird 是一个第三方 Promise 类库](#bluebird-是一个第三方-promise-类库)
  - [await wrap](#await-wrap)
  - [async lib bhaoyon](#async-lib-bhaoyon)

<!-- /TOC -->

# use sync library
request = require('sync-request'); 
async = require('async');
task=[];


url = "http://localhost:5000/friendGroup/add?access_token=tk888&groupName=grp999&salt=1669893571254&secret=xxUYkpr"
console.log(url) 
res = request('get', url,{});
console.log( (res.getBody('utf8')));

# Node.js 内置的 util.Promise 包装法

Node.js 内置的 util 模块有一个 promisify() 方法，该方法将基于回调的函数转换为基于 Promise 的函数。这使您可以将 Promise 链和 async/await 与基于回调的 API 结合使用。

# bluebird 是一个第三方 Promise 类库
浅谈bluebird包的使用理解_风逝-的博客-CSDN博客_bluebird …
bluebird 是一个第三方 Promise 类库，相比其它第三方类库或标准对象来说，功能更齐全而不臃肿

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
