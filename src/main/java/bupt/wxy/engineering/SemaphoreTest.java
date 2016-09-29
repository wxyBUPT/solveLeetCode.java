package bupt.wxy.engineering;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by xiyuanbupt on 9/26/16.
 */
public class SemaphoreTest {
    public static void main(String[] args){
        //采用新的特性来启动和管理线程--内部使用线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //只允许 5 个线程同时访问
        final Semaphore semp = new Semaphore(5);
        //模拟十个客户端访问
        for(int i = 0;i<10;i++){
            final int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try{
                        //获得许可
                        semp.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() + "获得许可: " + num);
                        for(int j = 0;j<999999;j++){

                        }
                        semp.release();
                        System.out.println("线程 " + Thread.currentThread().getName() + "获得许可: " + num);
                        System.out.println("当前允许进入的任务个数: " + semp.availablePermits());
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(runnable);
        }
        exec.shutdown();
    }
}
