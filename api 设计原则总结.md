api 设计原则总结

<!-- TOC -->

    - [最简单化内容。。最核心的内容代码。。](#最简单化内容最核心的内容代码)
    - [权限和异常 由框架处理](#权限和异常-由框架处理)
- [异常](#异常)
  - [dt 约束检验通过db uniq](#dt-约束检验通过db-uniq)
- [ret code use httpcode](#ret-code-use-httpcode)
- [dt flt use db view](#dt-flt-use-db-view)

<!-- /TOC -->

## 最简单化内容。。最核心的内容代码。。

## 权限和异常 由框架处理

# 异常
ex 不要自己抛出，，不要自己定义异常。使用默认异常框架throw ..so code zwi smp

## dt 约束检验通过db uniq
不要代码里面chk..

# ret code use httpcode 
500 zosh error..   no def rtcd.
use db ret cod,,execu sql or query sql.

# dt flt use db view 
