node打包为exe文件


C:\Users\tom\AppData\Roaming\npm\pkg.cmd -t win sqlt_sync.js

gene exe 在 D:\0src\nodesrc

运行console模式即可。全部包括了，大概40M 不错的exe打包。。

使用pkg可以将Node.js项目打包为可执行文件，甚至可以在未安装Node.js的设备上运行。

node.js - 如何用pkg打包nodejs可执行文件_个人文章 - SegmentFault 思否

node ver 16
pkg的打包原理简单来说，就是将js代码以及相关的资源文件打包到可执行文件中，然后劫持fs里面的一些函数，使它能够读到可执行文件中的代码和资源文件。