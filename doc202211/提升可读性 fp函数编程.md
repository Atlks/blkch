
stream  VAVR lib

<!-- TOC -->

- [stream类、Lambda表达式和函数接口](#stream类lambda表达式和函数接口)
- [chain链式编程](#chain链式编程)
- [匿名函数 lambda](#匿名函数-lambda)
- [func  try...VAVR 的 Try](#func--tryvavr-的-try)
- [stream  VAVR lib](#stream--vavr-lib)

<!-- /TOC -->


# stream类、Lambda表达式和函数接口
# chain链式编程

# 匿名函数 lambda

# func  try...VAVR 的 Try
通过 VAVR 的 Try，也能实现另外一种更 functional 的 try...catch。
/**
* 输出
*	 failure: / by zero
*  finally
*/
Try.of(() -> 1 / 0)
    .andThen(r -> System.out.println("and then " + r))
    .onFailure(error -> System.out.println("failure" + error.getMessage()))
    .andFinally(() -> {
      System.out.println("finally");
    });

# stream  VAVR lib

