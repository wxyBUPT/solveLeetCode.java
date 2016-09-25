
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

Executor 一般通过如下方法执行新的线程

```java
import java.util.concurrent.ExecutorService;   
import java.util.concurrent.Executors;   

public class TestCachedThreadPool{   
    public static void main(String[] args){   
        ExecutorService executorService = Executors.newCachedThreadPool();   
//      ExecutorService executorService = Executors.newFixedThreadPool(5);  
//      ExecutorService executorService = Executors.newSingleThreadExecutor();  
        for (int i = 0; i < 5; i++){   
            executorService.execute(new TestRunnable());   
            System.out.println("************* a" + i + " *************");   
        }   
        executorService.shutdown();   
    }   
}   

class TestRunnable implements Runnable{   
    public void run(){   
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");   
    }   
}  
```

还可以使用future 对象保存线程执行的结果

还可以自定义线程执行

```java
import java.util.concurrent.ArrayBlockingQueue;   
import java.util.concurrent.BlockingQueue;   
import java.util.concurrent.ThreadPoolExecutor;   
import java.util.concurrent.TimeUnit;   

public class ThreadPoolTest{   
    public static void main(String[] args){   
        //创建等待队列   
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);   
        //创建线程池，池中保存的线程数为3，允许的最大线程数为5  
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50,TimeUnit.MILLISECONDS,bqueue);   
        //创建七个任务   
        Runnable t1 = new MyThread();   
        Runnable t2 = new MyThread();   
        Runnable t3 = new MyThread();   
        Runnable t4 = new MyThread();   
        Runnable t5 = new MyThread();   
        Runnable t6 = new MyThread();   
        Runnable t7 = new MyThread();   
        //每个任务会在一个线程上执行  
        pool.execute(t1);   
        pool.execute(t2);   
        pool.execute(t3);   
        pool.execute(t4);   
        pool.execute(t5);   
        pool.execute(t6);   
        pool.execute(t7);   
        //关闭线程池   
        pool.shutdown();   
    }   
}   

class MyThread implements Runnable{   
    @Override   
    public void run(){   
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");   
        try{   
            Thread.sleep(100);   
        }catch(InterruptedException e){   
            e.printStackTrace();   
        }   
    }   
}  ```