前端对于 Flutter 的热忱度之高一度让人有点惊讶，事实上在 Flutter 社区内见到的客户端开发者远多于前端开发，不过前端对于跨端解决方案确实有着天然的渴求。优点： 1、跨平台； 2、性能强大，流畅，混合开发中，最接近原生开发的框架； 3、Dart语言简单易学； 4、极大降低了开发成本。原来需要招一个iOS、一个安卓，用了flutter后，只需要招一个flutter人员就够了；缺点： 1、Widget的类型难以选择，糟糕的UI控件API； 2、Dart 语言的生态小，精通成本比较高。 3、开发工具版本升级后，修改量大； 4、原生集成第三方SDK后，兼容性适配是个令人头痛的问题； 5、代码可读性较差（嵌套地狱），对代码质量和管理要求较高；简短版：flutter是个性能强大的框架，但是坑多。




Dart的另一个好处是，Flutter不会从程序中拆分出额外的模板或布局语言，如JSX或XML，也不需要单独的可视布局工具。以下是一个简单的Flutter视图，用Dart编写：

new Center(child:
  new Column(children: [
    new Text('Hello, World!'),
    new Icon(Icons.star, color: Colors.green),
  ])
)



创建一个最小的 Flutter 应用简单到仅需调用 runApp() 方法并传入一个 widget 即可：


runApp() 函数会持有传入的 Widget，并且使它成为 widget 树中的根节点。在这个例子中，Widget 树有两个 widgets， Center widget 及其子 widget —— Text widget。框架会强制让根 widget 铺满整个屏幕，也就是说“Hello World”会在屏幕上居中显示。在这个例子我们需要指定文字的方向，当使用 MaterialApp widget 时，你就无需考虑这一点，之后我们会进一步的描述。

在写应用的过程中，取决于是否需要管理状态，你通常会创建一个新的组件继承 StatelessWidget 或 StatefulWidget。 Widget 的主要工作是实现 build() 方法，该方法根据其它较低级别的 widget 来描述这个 widget。框架会逐一构建这些 widget，直到最底层的描述 widget 几何形状的 RenderObject。

