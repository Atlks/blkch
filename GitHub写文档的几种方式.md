GitHub写文档的几种方式

<!-- TOC -->

- [1. Github pages](#1-github-pages)
- [3. 利用github issue](#3-利用github-issue)
- [4. 利用github wiki](#4-利用github-wiki)
- [5. 直接在repo里提交markdown文件](#5-直接在repo里提交markdown文件)
- [自建](#自建)

<!-- /TOC -->

# 1. Github pages
2. 2. 直接提交静态文件到github pages (Hexo等)

# 3. 利用github issue

# 4. 利用github wiki 
github wiki当然也可以写 , github上每一个projec都有一个对应的wiki, 你可以在这里写 , 譬如 https://github.com/coffee-js/languages/wiki


# 5. 直接在repo里提交markdown文件
github建议每个项目都提供一个README.md文件, 在网页上浏览项目或子目录时, github会自动显示当前目录里的README.md文件, 利用这一功能, 也有人直接提交markdown文件, 譬如 https://github.com/kilimchoi/engineering-blogs, 这样也是一种方法, 只是打开你的blog时上面会先看到file list.

这样的做法其实就是把md文件当成源代码一样提交到github里.

优点:

相比前面几种, 好像没什么独有的优点

# 自建

6. 项目文档的好选择
最近在为公司项目文档选型的时候发现一个不错的项目https://docusaurus.io/, 这是Facebook的开源项目，基于Nodejs，使用markdown，非常适合用于写项目文档，也可用于个人知识整理，相当于是wiki+blog系统，非常方便，样式也不错，和GA、搜索等也都集成的不错，也可以和GitHub Pages集成。拍乐云的项目文档就使用了这个，参考这里：https://developer.pano.video, Enjoy！