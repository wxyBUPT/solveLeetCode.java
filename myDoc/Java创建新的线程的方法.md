
# Java 创建新的线程的方法

*一般都会说有两个方法,但是学习concurrent 包的时候还有其他更加高级的方式创建新的线程*  

### 常规的两个方法

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

* 通过实现Runnable 接口来创建新的线程 
 
 ```java
 MutliThreadDemo2 {
     public static void main(String [] args){
         MutliThread m1=new MutliThread("Window 1");
         MutliThread m2=new MutliThread("Window 2");
         MutliThread m3=new MutliThread("Window 3");
         Thread t1=new Thread(m1);
         Thread t2=new Thread(m2);
         Thread t3=new Thread(m3);
         t1.start();
         t2.start();
         t3.start();
     }
 }
 class MutliThread implements Runnable{
     private int ticket=100;//每个线程都拥有100张票
     private String name;
     MutliThread(String name){
         this.name=name;
     }
     public void run(){
         while(ticket>0){
             System.out.println(ticket--+" is saled by "+name);
         }
     }
 }
 ```
 
相比之下,实现Runnable 接口相比继承Threa类有如下优势

* 避免Java 的单继承特性带来的局限性
* 增强程序及安装新,代码能够被多个线程共享,代码与数据是独立的
* 适合多个相同程序代码的线程区处理同一个资源的情况

### Java5之后,通过Executor 来启动线程比使用 Thread 的start 方法更好

Executor 框架包括:线程池,Executor,Executors,ExecutorService,CompletionService,Future,Callable等

