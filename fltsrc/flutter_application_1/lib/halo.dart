import 'package:flutter/material.dart';

// D:\sdk\fluttersdk\bin\flutter doctor
//  创建一个最小的 Flutter 应用简单到仅需调用 runApp() 方法并传入一个 widget 即可：
//
void main() {
  runApp(MaterialApp(
      home: Scaffold(
          body: Column(children: <Widget>[
    new Text('  fld1', textAlign: TextAlign.left),
    TextField(),
    new Text(' fld2:'),
    TextField(
      decoration: InputDecoration(
        border: OutlineInputBorder(),
      ),
    ),
  ]))));
}
