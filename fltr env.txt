add fltr sdk 800M
恐怖啊。。。haosyo already inc dart sdk..

在 VS Code 里开发 Flutter 应用

##  创建项目
有几种方式创建一个新项目。

新建项目
通过 Flutter 入门应用模板新建 Flutter 项目：

打开命令面板（Ctrl+Shift+P （macOS 用 Cmd+Shift+P））。

选择 Flutter: New Project 命令然后按 Enter。

选择 Application 然后按 Enter。

选择 项目地址。

输入你想要的 项目名。


###  edit xx.dart    lib/main.dart
import 'package:flutter/material.dart';

 // D:\sdk\fluttersdk\bin\flutter doctor

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});


## select dvc and  run 

选择目标设备
当一个 Flutter 项目在 VS Code 中打开，你会在状态栏看到一些 Flutter 特有项，包括 Flutter SDK 版本和设备名称（或者无设备信息）：
dvc is win,chrome web  etc...

在 IDE 主窗口点击 Run > Start Debugging 或按 F5 开启调试。

Flutter 扩展会自动选择上次连接的设备。然而，如果你有多个设备/模拟器连接，点击状态栏的 device 查看屏幕顶部的选择列表。选择你要用来运行或调试的设备。

快速编辑和刷新开发周期
Flutter 提供一流的开发周期，通过 Stateful Hot Reload 特性使你在几乎修改代码的同时就能看到变化。详情请看 使用热重载。



