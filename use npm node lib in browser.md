use npm node lib in browser


里面的代码让它能直接在浏览器运行？还是必须用webpack来打包编译

安装完成以后，执行命令：

browserify main.js -o bundle.js
复制
命令运行完成以后，会生成一个bundle.js文件。现在我们就可以把这个文件和HTML代码放在一起，通过<script>标签导入了：