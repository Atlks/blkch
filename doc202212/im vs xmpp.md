im vs xmpp 

<!-- TOC -->

- [im 基本功能](#im-基本功能)
  - [文件传输,](#文件传输)
  - [语音和视频聊天](#语音和视频聊天)
- [底层协议 tcp http](#底层协议-tcp-http)
- [im协议2种 SIP/SIMPLE 和 XMPP了](#im协议2种-sipsimple-和-xmpp了)
- [1、什么是XMPP ?](#1什么是xmpp-)
  - [竞争标准SIP](#竞争标准sip)
  - [协议特性 去中心化](#协议特性-去中心化)
- [协议特性](#协议特性)
  - [去中心化](#去中心化)
  - [寻址  u@svr](#寻址--usvr)
  - [可扩展性 xml非常好](#可扩展性-xml非常好)
- [开源svr](#开源svr)
  - [Tigase](#tigase)
- [XMPP 协议的缺点或缺点](#xmpp-协议的缺点或缺点)
- [类似标准 mqtt sip](#类似标准-mqtt-sip)

<!-- /TOC -->

简而言之，XMPP（又称为Jabber）是一种开放的互联网实时通讯协议。很多流行的聊天软件都是XMPP的封装应用，比如Google Hangout、Facebook Message、AOLChat、米聊、人人桌面和陌陌等。很多网络游戏的内部聊天用的也是XMPP协议。
可扩展消息传递和状态协议（XMPP，原名Jabber[1]）是一种开放式通信协议，用于即时消息（IM），状态信息和联系人列表维护

# im 基本功能

## 文件传输,

在浏览器里,如果你不用WebRTC提供的点对点P2P的RTCDataChannel技术,可以这样做:用户通过HTTP把文件上传到服务器,然后服务器把文件的URL(字符串)推送给接收文件的用户.这样做的话,对服务器的带宽和存储压力比较大,传一些小文件(比如图片和文档)还可以,传大文件就太消耗服务器了.QQ

## 语音和视频聊天
,显然,这种场景用点对点的P2P技术最合适,在浏览器里,可以用WebRTC实现.WebRTC里实现点对点的P2P通信,需要一个防火墙打洞服务器ICE(STUN+TURN)来实现NAT穿透:

# 底层协议 tcp http

后逃不过 tcp或者udp传输。腾讯是铁定不会傻到拿http去做的。因为http的无状态性和不能推送(即 服务器像浏览器推送) 并且http效率上肯定不够，所以不用怀疑它一定是tcp或者udp

# im协议2种 SIP/SIMPLE 和 XMPP了

其实, 现在主要是SIP/SIMPLE 和 XMPP了

即时通讯协议(Instant Messaging),主流的IM协议有4种,即时消息和存在协议IMPP(Instant Messaging And PresenceProtocol),存在和即时消息协议PRIM(Presence and Instant Messageing Protocol),SIP即时消息和存在扩展协议SIMPLE(SIP for Instant Messaging and Presence Leveraging Extensions),可扩展消息与存在协议XMPP(Extensible Messageing and Presence Protocol.
————————————————
目前IM有四种协议：即时信息和空间协议(IMPP)、空间和即时信息协议(PRIM)、针对即时通讯和空间平衡扩充的进程开始协议SIP(SIMPLE)以及XMPP。PRIM与XMPP、 SIMPLE类似，但已经不再使用了。

# 1、什么是XMPP ?

XMPP的前身是Jabber，一个开源形式组织产生的网络即时通信协议。XMPP目前被IETF国际标准组织完成了标准化工作。标准化的核心结果分为两部分：

（1）核心的XML流传输协议

3、XMPP通过TCP传什么了?

传输的是与即时通讯相关的指令。在以前这些命令要么用2进制的形式发送(比如QQ)，要么用纯文本指令加空格加参数加换行苻的方式发送(比如MSN)。而XMPP传输的即时通讯指令的逻辑与以往相仿，只是协议的形式变成了XML格式的纯文本。这不但使得解析容易了，人也容易阅读了，方便了开发和查错。
————————————————
 ## 竞争标准SIP
XMPP 通常被视为基于 SIMPLE 的竞争对手，SIMPLE基于会话初始协议 （SIP），作为即时消息和状态通知的标准协议。[50][51]

用于多用户聊天的XMPP扩展[36]可以被视为Internet Relay Chat（IRC）的竞争对手，尽管IRC要简单得多，功能要少得多，并且使用更广泛。[需要引用]

用于发布-订阅[37]的XMPP扩展提供了许多与高级消息队列协议（AMQP）相同的功能


## 协议特性 去中心化

一个简单的XMPP网络，服务器 jabber.org 和 draugr.de。绿色客户端在线，黄色客户端相互写入，绿色小子客户端是一个用户的资源。棕色网络未连接到互联网。服务器 draugr.de 通过 XMPP 传输连接到其他 IM 服务（ICQ、AIM 和其他）。
XMPP 网络体系结构让人联想到简单邮件传输协议 （SMTP），这是一种客户端-服务器模型;客户端不直接相互通信，因为它是分散的 - 任何人都可以运行服务器。根据设计，没有像AIM，WLM，WhatsApp或Telegram等消息传递服务那样的中央权威服务器。在这一点上经常会出现一些混淆，因为有一个公共 XMPP 服务器正在 上运行，许多用户订阅了该服务器。但是，任何人都可以在自己的域上运行自己的 XMPP 服务器。

#  协议特性


## 去中心化

一个简单的XMPP网络，服务器 jabber.org 和 draugr.de。绿色客户端在线，黄色客户端相互写入，绿色小子客户端是一个用户的资源。棕色网络未连接到互联网。服务器 draugr.de 通过 XMPP 传输连接到其他 IM 服务（ICQ、AIM 和其他）。
XMPP 网络体系结构让人联想到简单邮件传输协议 （SMTP），这是一种客户端-服务器模型;客户端不直接相互通信，因为它是分散的 - 任何人都可以运行服务器。根据设计，没有像AIM，WLM，WhatsApp或Telegram等消息传递服务那样的中央权威服务器。在这一点上经常会出现一些混淆，因为有一个公共 XMPP 服务器正在 上运行，许多用户订阅了该服务器。但是，任何人都可以在自己的域上运行自己的 XMPP 服务器。jabber.org

## 寻址  u@svr

标准 JID
网络上的每个用户都有一个唯一的XMPP地址，称为JID[5]（由于历史原因，XMPP地址通常被称为Jabber ID）。JID 的结构类似于电子邮件地址，其中包含该用户所在服务器的用户名和域名（或 IP 地址 [6]），用 at 符号 （） 分隔 - 例如，“”：这是用户名和用户注册的服务器。@alice@example.comaliceexample.com

由于用户可能希望从多个位置登录，因此他们可以指定资源。资源标识属于用户的特定客户端（例如家庭、工作或移动）。这可以通过附加一个斜杠后跟资源名称来包含在 JID 中。例如，用户移动帐户的完整 JID 可以是 。username@example.com/mobile

每个资源可能都指定了一个名为优先级的数值。简单地发送到的消息将以最高优先级发送到客户端，但发送到的消息将仅发送到移动客户端。最高优先级是具有最大数值的优先

## 可扩展性 xml非常好
XMPP标准基金会或XSF（前身为Jabber软件基金会）积极开发开放的XMPP扩展，即所谓的XEP。[9] 但是，扩展也可以由任何个人、软件项目或组织定义。为了保持互操作性，公共扩展由 XSF 管理。IM 之外的 

# 开源svr
## Tigase


XMPP Servers
Openfire	Real time collaboration (RTC) server
jabberD	Next generation of the jabberd project
Prosody	Modern XMPP server that's easy to set up
ejabberd	XMPP application server and an MQTT broker
MongooseIM	Mobile messaging platform with focus on performance and scalability

与通常我们使用的集中式架构的通讯软件（如QQ、微信）不同，采取邦联式架构的XMPP客户端与服务器、服务器之间的通信使用的是公开而标准化的协议——这保证了任何人都可以参考这些标准开发出可以和系统中其他组件互操作的组件，甚至可以自己搭建服务器，为自己提供服务。通过XMPP所支持的“不留记录即时通讯协议（Off-the-Record Messaging，缩写为OTR，原理见https://hardenedlinux.github.io/cryptography/2018/02/01/pidgin_xmpp_otr_debian.html）”，可以实现端到端通讯的加密，从而保障“私聊”的真正“私密”性质和通讯的安全性。


1. Openfire (Wildfire) 3.x

底层通讯采用的mina框架，minak框架其实性能一般，netty早已经超越它，虽然最初都是Doug Lea写的。3.4版本之后支持集群，单台服务器测试最大支持30万用户并发，服务器配置（服务器是Dell R710， 64G内存 16核CPU，15000转硬盘），缺点是大规模并发时集群效果不是很好。
性能优化学习：http://blog.csdn.net/smm11230704/article/details/7468010
授权: GPL or 商用
操作系统平台：所有(使用Java开发)
XMPP Jabber 协议实现情况：98%
Tim 评价：
安装和使用非常简单，安装后进入Web界面进行2~3分钟的配置所有的东西都设好了。使用Java语言开发，在目前Java开发人员到处普及的情况下进行维护和扩展的成本非常低。在我的测试中加上 Connection Manager 的情况下单台服务器可支持 30 万并发用户。缺点是目前还不支持Cluster。如果企业内部部署IM使用 Wildfire + Spark 是最佳的组合。
见：http://hi.baidu.com/jabber/blog/Category/Wildfire




6. tigase:
1）底层通讯是自己写的一个NIO通讯框架， 最高并发连接可达到单机50w，支持集群（可以根据需要进行水平扩展），个人感觉这个比较靠谱。
部署学习：http://xiao9.iteye.com/blog/1488070

2）.Tsung负载测试Tigase：http://linyu19872008.iteye.com/blog/1605707

3）典型案例：Zoosk，是一个具有5000万会员的浪漫的社交约会网站

4）详解Zoosk千万用户实时通信背后的开源技术：
http://www.csdn.net/article/2012-09-10/2809790-zoosk-the-engineering-behind-real-time

5）缺点：集群方式复杂--但是tigase 作者维护很活跃，集群测试结果能够支撑比较大的容量，这是吸引人的地方。但经过实际生产运营情况来看，由于其集群方案实现的复杂性，以及单节点容量的有限，对支撑到 50 万用户在集群节点上可能没有信心，所以在到达 50 万用户之前，自己要准备替代方案。


XMPP客户端
XMPP 系统的一个设计标准是必须支持简单的客户端。事实上，XMPP 系统架构对客户端只有很少的几个限制。一个XMPP 客户端必须支持的功能有：

通过 TCP 套接字与XMPP 服务器进行通信；
解析组织好的 XML 信息包；
理解消息数据类型。
至于对客户端为何要求如此简单，概括来说就是，xmpp把相关更多功能实现都放在了服务器端去实现和处理，这样使得客户端相对解放出来。。这使得客户端编写变得非常容易，更新系统功能也同样变得容易。

XMPP 客户端与服务端通过XML 在TCP 套接字的5222 端口进行通信，而不需要客户端之间直接进行通信。
基本的XMPP 客户端必须实现以下标准协议（XEP-0211）：

RFC3920 核心协议Core
RFC3921 即时消息和出席协议Instant Messaging and Presence
XEP-0030 服务发现Service Discovery
XEP-0115 实体能力Entity Capabilities
————————————————
XMPP服务器
XMPP 服务器遵循两个主要法则：

监听客户端连接，并直接与客户端应用程序通信；
与其他 XMPP 服务器通信；
不要小看它只需遵循的原则少，这两个原则是所有xmpp服务器的核心与根本，不然，基于xmpp的im根本无从谈起，更别说基于此的模块化扩展了…



# XMPP 协议的缺点或缺点
以下是 XMPP 协议的缺点或缺点：
➨它没有 MQTT 协议使用的 QoS 机制。
➨与基于二进制的通信相比，基于文本的通信使流 XML 具有开销。


与大多数商业即时消息协议不同，XMPP 是在应用层的开放标准中定义的。XMPP 网络的架构类似于电子邮件;任何人都可以运行自己的XMPP服务器，并且没有中央主服务器。这种联合开放系统方法允许用户使用类似于电子邮件地址的“JID”用户帐户与任何服务器上的其他人进行互操作

复杂的presence
XMPP是有Presence的, TCP长连接的状态决定了Client是否在线, 为了避免假连接, 频繁掉线重连干扰用户体验等, 需要维护好TCP的长连接, 定时heartbeat, 要有断网重连机制(用户无感知)等等。
另外, XMPP里的Presence业务逻辑也比较复杂, 包括RFC 6121里的Basic Presence, 还有MUC presence, Temp Presence等, 为了实现Presence, Client和Server都增加了非常多的复杂度。对于mobile-first的IM产品, 都是假设用户时刻available的, 对于用户来说最重要的是聊天列表, 传统IM的Presence并不重要, 譬如微信就没有Presence
————————————————
# 类似标准 mqtt sip

而 MQTT 是最近几年随着物联网行业的发展，才慢慢进入公众视线的，像 Facebook Messenger App 使用了 MQTT 协议。
MQTT 的特点在于报文小，协议简单，提供了三个 QoS 级别。这几个特性是专门为网络环境复杂的物联网(IoT)场景设计的。

MQTT 协议本身过于简单，放在实时聊天协议里的话，多数功能是要自己定制协议来实现的，但总归可以用。

MQTT 被越来越多的用在 IM 应用上，XMPP 是要退出历史舞台了么？
我的 IM App 到底该选用 MQTT 吗？


IM 功能
XMPP 在 IM 的各个功能上的定义非常完善，而 MQTT 需要在基础协议之上自行实现。

认证
XMPP: 通过 SASL RFC4422
MQTT: 协议未定义，通常的实现方式是定制 CONNECT 报文中的 username 和 password 字段，因为 MQTT 只提供了这两个字段可以自行发挥。比如定义 username 为 {"uname": "Shawn", "dtype": "mobile"}, password 为 JWT。(MQTT 5.0 里添加了 AUTH 消息类型)。然后在 MQTT 后台处理 CONNECT 消息进行认证。
在设计的时候是需要仔细考虑的部分。
多设备
XMPP: 核心协议里有定义，通过 resource 实现。比如用户 shawn@emqx.io 的两个设备分别是： shawn@emqx.io/pc, shawn@emqx.io/mobile。
MQTT: 协议未定义。因为 MQTT 协议里，唯一标识设备使用的是 Client ID，所以设计的难点在于，如何定义 Client ID 的格式，并且能够跟 IM 需求里的 username 做对应，并且实现多终端同步。常见的做法是：
限制用户名里不能有特殊字符 '@', '/';
对于 ClientID 的格式为 'username@device', 比如用户 "shawn" 的两个 ClientID: "shawn@pc", "shawn@mobile"。
对于用户 shawn 的这两个终端，通过订阅相同的主题来同步所有别人发来的聊天消息。比如都订阅主题：'p2p/talk/shawn'。并且向外发送消息时需要将消息复制到主题 'p2p/talk/shawn' 以同步发出的消息，这样做时，还需要忽略自己发出的同步消息。
不适合，首先传输用的是XML，构造和解析复杂，传输冗余大。
另外，它对不稳定的移动网络不友好，经常会发生丢消息的情况。
我认为成熟的移动IM，（或者根本不应该叫IM，移动网络的特点本身就决定了它不适合做即时通讯）应该同时兼容socket和HTTP，网络好的时候用socket保证实时性，网络差的时候用HTTP保证可靠性。
还有一个血的教训是，不要让它负责除了聊天之外的其他任何事情，好友关系处理、用户资料设置什么的，最好都自己另外弄一套。XMPP自带的扩展和传输都很麻烦

XMPP太重，如果需求不复杂，socket.io自己定义下协议就够用了。

文本沟通的话IRC协议就够了，只是IRC更面向群聊

文件传输与音视频这块，其实XMPP也就负责握个手，该怎么走RTCP，到时还得怎么走。


通过SP的引入，可以解决过去一些纯粹基于p2p技术的IM应用的缺点，比如它们完全靠用户自发（或者给予一定奖励）的方式来建立点对点网络，但是很显然，普通用户的建网能力和服务能力是无法跟专业的SP相提并论的，所以这是过往的基于p2p技术的IM难以发展推广的原因。而通过统一的账号设计，又能解决过去那些IM挑战者们单打独斗的局面，所有小SP可以联合起来，拼接成一张大网络，并且通过自由竞争、而不是靠垄断手段来实现更