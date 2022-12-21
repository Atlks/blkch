gui form window struts parse xxx spy

debug ui

h5 brower dev tool parser

WinSpy++是一个方便的程序员实用程序，可用于选择和查看系统中任何窗口的属性。


.NET Windows Forms Spy


 本文描述如何使用一个名为ManagedSpy的新工具并且它的关联库ManagedSpyLib，它们均可从MSDN®Magazine网址下载（译注：已包含在本文源代码下载链接ManagedSpy.rar中，其中的TestManagedSpy解决方案是译者为方便大家所做）。与Spy++显示Win32® 信息比如窗体类、样式和消息相似，ManagedSpy显示托管控件、属性和事件。ManagedSpyLib允许你以编程方式访问另一个进程中的Windows®窗体控件。你可以获得并设置属性以及在你自己的代码中事件上同步。ManagedSpyLib也可以帮助你创建测试带（test harnesses）并且可以执行窗体、消息和事件记录（event logging）。
————————————————
Net UI Spy工具:ManagedSpy. 很久之前在接手一个大型的Winform项目的时候。. 有如下困难：. 基于以上的现状，项目组中的人员，没有谁对于整体能大概的把握。. 那么在维护和修改的时候，如何能根据UI 

当时首先想到的就是找一个UI Spy工具，来辅助这个需求。经过一番实践，发现：ManagedSpy最为好用。当然了，有时候也会配合另一个类似工具：Object Spy一起使用。

关于ManagedSpy，你能从：http://msdn.microsoft.com/en-us/magazine/cc163617.aspx获得更加详细的说明和工具源码。

关于Object Spy，你能从：http://www.codeproject.com/KB/dotnet/objectspy.aspx获得详细的说明和工具源码


监视您的用户界面

编写客户端应用程序时，在许多情况下，传统调试器没有用处。例如，如果 bug 涉及焦点或其他 UI 方面，则很难调试，因为每当遇到断点时，调试器都会修改此状态。另一个难以调试的问题是布局。如果您的窗体具有复杂的动态布局，则布局逻辑是否被多次调用并不总是很明显。若要调试这些问题，通常必须求助于事件或消息日志记录，以了解向 UI 馈送的输入。

对于复杂的 UI，具有窗口和关联状态的视图非常有用。例如，可能很难在调试器中找到相关的控件对象。大多数情况下，您必须猜测调试器变量是您在 UI 中查看的变量。

图 1 显示了一个包含几个嵌套控件的对话框。此应用程序在右上角的文本框中有一个错误，尽管出于此示例的目的，错误是什么并不重要。不仅要标识哪个成员是红色文本框，还要标识相关控件的父层次结构和布局，这将非常有用。


ManagedSpy是一个诊断工具，类似于Spy++。它显示托管属性，允许您记录事件，并且是使用 ManagedSpyLib 的一个很好的例子。ManagedSpyLib引入了一个名为ControlProxy的类。ControlProxy 是另一个进程中 System.Windows.Forms.Control 的表示形式。ControlProxy 允许您获取或设置属性并订阅事件，就像您在目标进程中运行一样。使用 ManagedSpyLib 进行自动化测试、事件日志记录以实现兼容性、跨进程通信或白盒测试。