虚拟化技术  vm虚拟机


虚拟机的话，在wikipedia上定义分为两种，系统虚拟机-system virtual machines，进程虚拟机process virtual machines；另外还有一个非虚拟机类型的虚拟化技术：操作系统层次虚拟化技术operation system level virtualization；

系统虚拟机-system vm，为操作系统的安装运行提供虚拟环境，它模拟提供了硬件操作环境。例如他模型出一套个人电脑的硬件环境，在这个硬件环境下，我们可以安装各种操作系统win7/win10/centos/ubuntu等，然后进入安装的操作系统中，使用操作系统。

进程虚拟机-process vm，为进程运行提供虚拟环境，它模拟了操作系统的环境，例如cpu指令系统，堆栈，寄存器等。在模拟出的操作系统下，相应匹配的二进制程序或字节码可以拉起执行。

操作系统层虚拟化-operation system level virtualization，亦称为容器化containerization，这种技术将当前操作系统的内核虚拟化，用户空间软件实例被分割成多个各自独立运行。典型应用就是lxc-linux container，为linux用户空间接口，它将应用程序+所需操作系统核心和库打包到一起，放入到一个独立的用户空间运行，创建出类似沙盒的运行环境。
————————————————


虚拟机
cpu 内存 io磁盘 console(screen)
network api
