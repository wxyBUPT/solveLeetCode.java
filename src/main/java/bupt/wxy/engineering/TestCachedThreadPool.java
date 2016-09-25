package bupt.wxy.engineering;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiyuanbupt on 9/25/16.
 */
public class TestCachedThreadPool {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            executorService.execute(new TestRunable());
            System.out.println("***** a " + i + " ******");
        }
        executorService.shutdown();

        executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            executorService.execute(new TestRunable2(i));
        }
        executorService.shutdown();
    }

}

class TestRunable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了.");
    }
}

class TestRunable2 implements Runnable{
    int a;
    public TestRunable2(int a){
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了" + a);
    }
}
