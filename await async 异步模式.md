。被async修饰的方法返回一个Future，调用这样的方法，相当于创建一个Future。await一个Future，相当于把await之后的代码打包放在Future.then()的代码块里，这样就保证之后的代码在Future之后执行。由于任务存储于事件队列，dart在流量大的时候，内存消耗较

promise 模式


异步
Future
Future 跟 JavaScript 的Promise 差不多，要使用async和await来让代码变成异步的。必须在带有 async 关键字的 异步函数 中使用 await：