##### Hotspot JVM提供以下三大类选项:
1.标准选项：以-开头，例如：-version,-server。  
2.X选项：比如-Xms，运行java -X命令可以看到所有的X选项。  
3.XX选项：主要是给JVM开发者用于开发和调试JVM的。  

XX选项的语法：
> * 如果是布尔类型的选项，它的格式为-XX:+flag或者-XX:-flag，分别表示开启和关闭该选项。  
> * 针对非布尔类型的选项，它的格式为-XX:flag=value  

常用的选项：  
指定JVM的类型：-server，-client
Hotspot JVM有两种类型，分别是server和client。  

区别：  
Server VM的初始堆空间会大一些，默认使用的是并行垃圾回收器。    
Client VM的初始堆空间会小一些，使用串行的垃圾回收器，目的是为了让JVM的启动速度更快。  

VM在启动的时候根据**硬件和操作系统**会自动选择使用Server还是Client类型的JVM。  
在32位Windows系统上，不论硬件配置如何，都默认使用Client类型的JVM。  
在其他32位操作系统上，如果机器**配置有2GB集群以上的内存同时有2个以上的CPU，** 则默认会使用Server类型的JVM。
64位机器上只有Server类型的JVM。也就是说Client类型的JVM只在32位机器上提供。  

指定JIT编译器的模式：-Xint，-Xcomp，-Xmixed  
> * -Xint表示禁用JIT，所有字节码都被解释执行，这个模式的速度最慢的。  
> * -Xcomp表示所有字节码都首先被编译成本地代码，然后再执行。  
> * -Xmixed，默认模式，让JIT根据程序运行的情况，有选择地将某些代码编译成本地代码。  

-version和-showversion  
-version就是查看当前机器的java是什么版本，是什么类型的JVM（Server/Client），采用的是什么执行模式。  
```
java version "1.8.0_101"
Java(TM) SE Runtime Environment (build 1.8.0_101-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.101-b13, mixed mode)
```  
-showversion的作用是在运行一个程序的时候首先把JVM的版本信息打印出来。  

查看XX选项的值： -XX:+PrintCommandLineFlags， -XX:+PrintFlagsInitial和-XX:+PrintFlagsFinal  
-XX:+PrintCommandLineFlags可以让在程序运行前打印出用户手动设置或者JVM自动设置的XX选项。  
```
-XX:InitialHeapSize=125614912 -XX:MaxHeapSize=2009838592 -XX:+PrintCommandLineFl
ags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesInd
ividualAllocation -XX:+UseParallelGC
java version "1.8.0_101"
Java(TM) SE Runtime Environment (build 1.8.0_101-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.101-b13, mixed mode)
```  
-XX:+PrintFlagsInitial表示打印出所有XX选项的默认值  
-XX:+PrintFlagsFinal表示打印出XX选项在运行程序时生效的值。  

内存大小相关的选项  
> * -Xms 设置初始堆的大小，也是最小堆的大小，它等价于：-XX:InitialHeapSize  
> * -Xmx 设置最大堆的大小，它等价于-XX:MaxHeapSize。
如果堆的初始值和最大值不一样的话，JVM会根据程序的运行情况，自动调整堆的大小，这可能会影响到一些效率。针对服务端程序，一般是把堆的最小值和最大值设置为一样来避免堆扩展和收缩对性能的影响。  
> * -XX:PermSize 用来设置永久区的初始大小  
> * -XX:MaxPermSize 用来设置永久区的最大值  
永久区是存放类以及常量池的地方，如果程序需要加载的class数量非常多的话，就需要增大永久区的大小。  
> * -Xss 设置线程栈的大小，线程栈的大小会影响到递归调用的深度，同时也会影响到能同时开启的线程数量。  

OutofMemory（OOM）相关的选项  
如果程序发生了OOM后，JVM可以配置一些选项来做些善后工作，比如把内存给dump下来，或者自动采取一些别的动作。  
> * -XX:+HeapDumpOnOutOfMemoryError 表示在内存出现OOM的时候，把Heap转存(Dump)到文件以便后续分析，文件名通常是java_pid<pid>.hprof，其中pid为该程序的进程号。  
> * -XX:HeapDumpPath=<path>: 用来指定heap转存文件的存储路径，需要指定的路径下有足够的空间来保存转存文件。  
> * -XX:OnOutOfMemoryError 用来指定一个可行性程序或者脚本的路径，当发生OOM的时候，去执行这个脚本。  
例如：
```
$ java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof -XX:OnOutOfMemoryError ="sh ~/cleanup.sh" MyApp  
```
上面的命令可以使得发生OOM时，Heap被保存到文件/tmp/heapdump.hprof,同时执行Home目录中的cleanup.sh文件  

