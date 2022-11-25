console.log(111)
console.log(222)
console.log(333)


addd prj tmplt

dotnet new console -o MyApp -f net7.0

>dotnet run --project D:\0src
找不到要运行的项目。请确保 D:\0src 中存在项目，或使用 --project 传递项目路径。

dotnet run --project C:\Users\rr\MyApp


bin/xxx.exe file gene..zo

缓存
缓存是Redis最常见的应用场景，之所有这么使用，主要是因为Redis读写性能极高。Redis读的速度是110000次/s,写的速度是81000次/s，大约是mysql的正常读写速度的7倍，而且逐渐取代memcached，成为首选服务端缓存的数据库。而且，Redis内部是支持事务的，在使用时候能有效保证数据的一致性。且支持多种数据类型，应用场景会更加丰富。 作为缓存使用时，一般有两种方式保存数据：
1、读取前，先去读Redis，如果没有数据，再读取数据库，将数据拉入Redis。
2、插入数据时，同时写入Re

教程：使用 Visual Studio Code 创建 .NET 控制台应用程序
项目
2022/11/17
18 个参与者
选择 .NET 版本 。net7 6 5 ,net core3...ma net4 pa chonf l; .guji..
本教程演示如何使用 Visual Studio Code 和 .NET CLI 创建并运行 .NET 控制台应用程序。 项目任务（例如创建、编译和运行项目）通过使用 .NET CLI 来完成。 你可以遵循本教程中的步骤使用其他代码编辑器，然后在终端中运行命令（如果你愿意）。
