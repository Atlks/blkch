use npm node lib in browser


里面的代码让它能直接在浏览器运行？还是必须用webpack来打包编译

安装完成以后，执行命令：

browserify main.js -o bundle.js
复制
命令运行完成以后，会生成一个bundle.js文件。现在我们就可以把这个文件和HTML代码放在一起，通过<script>标签导入了：

Browserify：浏览器加载Node.js模块
随着JavaScript程序逐渐模块化，在ECMAScript 6推出官方的模块处理方案之前，有两种方案在实践中广泛采用：一种是AMD模块规范，针对模块的异步加载，主要用于浏览器端；另一种是CommonJS规范，针对模块的同步加载，主要用于服务器端，即node.js环境。

Browserify是一个node.js模块，主要用于改写现有的CommonJS模块，使得浏览器端也可以使用这些模块。使用下面的命令，在全局环境下安装Browserify。


$ npm install -g browserify



生成前端模块
有时，我们只是希望将node.js的模块，移植到浏览器，使得浏览器端可以调用。这时，可以采用browserify的-r参数（--require的简写）。


browserify -r through -r ./my-file.js:my-module > bundle.js
上面代码将through和my-file.js（后面的冒号表示指定模块名为my-module）都做成了模块，可以在其他script标签中调用。


<script src="bundle.js"></script>
<script>
  var through = require('through');
  var myModule = require('my-module');
  /* ... */
</script>

可以看到，-r参数的另一个作用，就是为浏览器端提供require方法。