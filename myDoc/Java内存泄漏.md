
[Java的内存泄漏](https://www.ibm.com/developerworks/cn/java/l-JavaMemoryLeak/) 

GC 监控每个对象的运行状态,包括对象的申请,引用,被引用,复制

Java 使用有向图的方式进行内存管理(循环引用)(内存管理精度高但是效率低)
使用计数器管理 精度低(很难处理循环引用的问题)但是执行效率高

一个内存泄漏的例子
```java

Vector v = new Vector(10);
for(int i = 0;i<100;i++){
    Object o = new Object();
    v.add(o);
    o = null;
}
```