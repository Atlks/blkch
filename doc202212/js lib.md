js lib

实用功能
1. qs
一个简单易用的字符串解析和格式化库

mitt

微型 200b 功能事件发射器/发布订阅.

import mitt from 'mitt'
const emitter = mitt()
emitter.on('foo', e => console.log('foo', e) )
emitter.on('*', (type, e) => console.log(type, e) )
emitter.emit('foo', { a: 'b' })
emitter.all.clear()

function onFoo() {}
emitter.on('foo', onFoo)   // listen
emitter.off('foo', onFoo)  // unliste
day.js
Day.js是一个极简主义的 JavaScript 库，它为现代浏览器解析、验证、操作和显示日期和时间，并具有很大程度上与 Moment 兼容的 API。


7.validator
Validator是一个字符串验证器和清理器库。

var validator = require('validator');
validator.isEmail('foo@bar.com'); //=> true


10.date-fns
Date-fns提供了最全面、最简单且一致的工具集，用于在浏览器和 Node.js 中操作 JavaScript 日期。


11.jsonwebtoken

Jsonwebtoken是一个用于对 JSON Web 令牌进行签名、验证和解码的库。

const jwt = require('jsonwebtoken');
const token = jwt.sign({ foo: 'bar' }, 'shhhhh');

作者：腾讯TNTWeb前端团队
二、操作文件系统
1.rimraf

Rimraf 为节点提供了与 UNIX rm -rf 命令等效的命令。

const rimraf = require('rimraf');
rimraf('./build', error => {
  if (error) console.error(error);
});
复制代码
2.fs-extra

FS-extra 添加了未包含在本机 fs 模块中的文件系统方法，并为 fs 方法添加了 promise 支持。

const fs = require('fs-extra');
async function copyFiles () {
  try {
    await fs.copy('/tmp/myfile', '/tmp/mynewfile');
    console.log('success!');
  } catch (err) {
    console.error(err);
  }
}
copyFiles();
复制代码
3.mkdirp

就像 mkdir -p 一样，mkdirp 递归地创建目录和所有必要的子目录。

const mkdirp = require('mkdirp')
// return value is a Promise resolving to the first directory created
mkdirp('/tmp/foo/bar/baz').then(made =>
  console.log(`made directories, starting with ${made}`));
复制代码
4.glob

Glob 是一个使用多种模式匹配文件的库。

const glob = require('glob');
// options is optional
glob("**/*.js", options, function (er, files) {

5.shelljs

ShellJS 是基于 Node.js API 的 Unix shell 命令的可移植 (Windows/Linux/OS X) 实现。

const shell = require('shelljs');
if (!shell.which('git')) {
  shell.echo('Sorry, this script requires git');

6.js-yaml

Js-yaml 是 YAML 的一种实现，YAML 是一种流行的人性化数据序列化语言。

const yaml = require('js-yaml');
const fs   = require('fs');
// Get document, or throw exception on error
try {
  const doc = yaml.load(fs.readFileSync('/home/ixti/example.yml', 'utf8'));

4. socket.io

Socket.IO使用长轮询或 WebSockets 启用实时双向基于事件的通信，并具有断开连接检测和自动重新连接支持。

const server = require('http').createServer();
const io = require('socket.io')(server);
io.on('connection', client => {
  client.on('event', data => { /* … */ });
  client.on('disconnect', () => { /* … */ });
});
server.listen(3000);

作者：腾讯TNTWeb前端团队
链接：https://juejin.cn/post/7002054481252728869
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。