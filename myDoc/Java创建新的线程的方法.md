
# Java 创建新的线程的方法

* 通过扩展 Thread类来创建多线程

```java
public class MutliThreadDemo {
    public static void main(String [] args){
        MutliThread m1=new MutliThread("Window 1");
        MutliThread m2=new MutliThread("Window 2");
        MutliThread m3=new MutliThread("Window 3");
        m1.start();
        m2.start();
        m3.start();
    }
}
class MutliThread extends Thread{
    private int ticket=100;//每个线程都拥有100张票
    MutliThread(String name){
        super(name);//调用父类带参数的构造方法
    }
    public void run(){
        while(ticket>0){
            System.out.println(ticket--+" is saled by "+Thread.currentThread().getName());
        }
    }
}
```
* 