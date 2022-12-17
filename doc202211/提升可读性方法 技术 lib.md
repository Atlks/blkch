提升可读性方法
<!-- TOC -->

- [架构层次可读性 简化层次结构架构](#架构层次可读性-简化层次结构架构)
  - [尽可能不要过度设计多层](#尽可能不要过度设计多层)
  - [业务层 +uti模式   BU模式](#业务层-uti模式---bu模式)
  - [减少类库](#减少类库)
  - [static import 模式展开api](#static-import-模式展开api)
  - [适当使用内部匿名类  匿名方法 lamda](#适当使用内部匿名类--匿名方法-lamda)
- [编程范式 面向过程、oo和fp函数式编程。](#编程范式-面向过程oo和fp函数式编程)
  - [stream类、Lambda表达式和函数接口](#stream类lambda表达式和函数接口)
  - [chain链式编程](#chain链式编程)
- [提升语法可读性 降低语法噪音](#提升语法可读性-降低语法噪音)
  - [script.script node python](#scriptscript-node-python)
  - [chain api](#chain-api)
  - [语法糖 增强api](#语法糖-增强api)
  - [trycatch api包装 忽略模式](#trycatch-api包装-忽略模式)
  - [dsl  sql解析库](#dsl--sql解析库)
  - [内嵌dsl scrpt](#内嵌dsl-scrpt)
  - [str增强库](#str增强库)
  - [集合增强库](#集合增强库)
  - [apiEx增强api 可读性 trycatch log增强](#apiex增强api-可读性-trycatch-log增强)
  - [提前定义。。预先定义](#提前定义预先定义)
  - [stream option api ,static import api](#stream-option-api-static-import-api)
  - [lambda](#lambda)
  - [避免长函数 俩屏幕长度](#避免长函数-俩屏幕长度)
  - [可读性增强api vs 性能增强api](#可读性增强api-vs-性能增强api)
  - [fp dsl 函数式编程](#fp-dsl-函数式编程)
  - [双大括号提升可读性 匿名内部类](#双大括号提升可读性-匿名内部类)
  - [类型自动判定，也就是关键字 +名称这种模式。](#类型自动判定也就是关键字-名称这种模式)
- [使用dsl提升可读性sql](#使用dsl提升可读性sql)
  - [h5 + sql+sqlite](#h5--sqlsqlite)
  - [使用sql库来提升可读性druid](#使用sql库来提升可读性druid)
  - [scrpt](#scrpt)
  - [vavr stream类库](#vavr-stream类库)
  - [集合操作类库stream](#集合操作类库stream)
- [逻辑可读性 同步 vs 异步](#逻辑可读性-同步-vs-异步)
  - [await  ,,sync lib](#await--sync-lib)
  - [尽可能同步优先](#尽可能同步优先)
  - [不要ioc aop](#不要ioc-aop)
- [数据传递可读性](#数据传递可读性)
  - [多使用mgdb json](#多使用mgdb-json)
  - [json in mysql pgsql](#json-in-mysql-pgsql)
- [函数式 API lib](#函数式-api-lib)

<!-- /TOC -->

# 架构层次可读性 简化层次结构架构
## 尽可能不要过度设计多层
##  业务层 +uti模式   BU模式
## 减少类库
## static import 模式展开api

## 适当使用内部匿名类  匿名方法 lamda

#   编程范式 面向过程、oo和fp函数式编程。

## stream类、Lambda表达式和函数接口
 现在主流的编程范式主要有三种，面向过程、面向对象和函数式编程。
Java为函数式编程引入了三个新的语法概念：Stream类、Lambda表达式和函数接口（Functional Inteface）。Stream类用来支持通过“.”级联多个函数操作的代码编写方式；引入Lambda表达式的作用是简化代码编写；函数接口的作用是让我们可以把函数包裹成函数接口，来实现把函数当做参数一样来使用（Java 不像C那样支持函数指针，可以把函数直接当参数来使用）。

Stream类
假设我们要计算这样一个表达式：(3-1)*2+5。如果按照普通的函数调用的方式写出来，就是下面这个样子：

add(multiply(subtract(3,1),2),5);
不过，这样编写代码看起来会比较难理解，我们换个更易读的写法，如下所示：

subtract(3,1).multiply(2).add(5);

在Java中，“.”表示调用某个对象的方法。为了支持上面这种级联调用方式，我们让每个函数都返回一个通用的Stream类对象。在Stream类上的操作有两种：中间操作和终止操作。中间操作返回的仍然是Stream类对象，而终止操作返回的是确定的值结果。

函数接口
实际上，上面一段代码中的Function、Predicate、Comparator都是函数接口。我们知道，C语言支持函数指针，它可以把函数直接当变量来使用。

java.util.function 它包含了很多类，用来支持 Java的 函数式编程，该包中的函数式接口有：

序号	接口 & 描述
1	BiConsumer<T,U>
代表了一个接受两个输入参数的操作，并且不返回任何结果

2	BiFunction<T,U,R>
代表了一个接受两个输入参数的方法，并且返回一个结果
## chain链式编程

# 提升语法可读性 降低语法噪音

## script.script node python
## chain api
## 语法糖 增强api  

增强log trycatch api包装 忽略模式
##  trycatch api包装 忽略模式


## dsl  sql解析库

druid 这一类。

## 内嵌dsl scrpt

## str增强库  
## 集合增强库

## apiEx增强api 可读性 trycatch log增强

## 提前定义。。预先定义 

FindIterable<Document> documents;
这样可以后面直接使用

FindIterable<Document> documents;
		MongoClient mongoClient;
		String sql;

## stream option api ,static import api    

## lambda

## 避免长函数 俩屏幕长度

## 可读性增强api vs 性能增强api

## fp dsl 函数式编程

## 双大括号提升可读性 匿名内部类

	whr = new Document() {
					{
						put(colname, val);
					}
				};

## 类型自动判定，也就是关键字 +名称这种模式。

类型推定的基本原则是：只要通过上下文能猜测到的，就不需要明确声明它的类型

因为，一个显而易见的点是，这样的代码确实更简洁。

# 使用dsl提升可读性sql

## h5 + sql+sqlite
## 使用sql库来提升可读性druid
## scrpt

##  vavr stream类库
六、Try对异常的处理

　　在Java中，如果发生异常且未进行捕获，则当前线程就会被中断，后续的调用就会停止。而Java中通过try{}catch(){}对可能出现异常的代码块进行捕获，保证了发生异常之后能够进行有效的处理，且顺利的执行完余下的工作。但问题是通过大量的try{}catch代码块看起来较为臃肿。vavr中通过Try类型则很好的解决了try{}catch的臃肿问题。

## 集合操作类库stream 

# 逻辑可读性 同步 vs 异步

## await  ,,sync lib
## 尽可能同步优先
## 不要ioc aop




# 数据传递可读性
## 多使用mgdb json
## json in mysql pgsql


# 函数式 API lib
一定程度上支持了函数式编程，但标准库提供的函数式 API 不是很完备和友好。
为了更好的进行函数式编程，我们就不得不借助于第三方库，而 VAVR 就是这方面的佼佼者，它可以有效减少代码量并提高代码质量。
VAVR 可不是默默无闻之辈，它的前身是发布于 2014 年的 Javaslang，目前在 github 上有着近 4k 的 star。

作者：vran
链接：https://juejin.cn/post/6854573219467411470
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。