package bupt.wxy.engineering;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by xiyuanbupt on 9/26/16.
 */
public class CompletionServiceDemo {
    public static class Task implements Callable<Integer> {

        private int i ;

        @Override
        public Integer call() throws Exception {
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(Thread.currentThread().getName() + "  " + i);
            return i;
        }

        Task(int i){
            this.i = i;
        }
    }

    public void run() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(pool);

        try {
            for (int i = 0; i < 10; i++) {
                completionService.submit(new CompletionServiceDemo.Task(i));
            }
            for (int i = 0; i < 10; i++) {
                // take 方法等待下一个结果并返回 Future 对象
                // poll 不等待,有结果就返回一个Future 对象,否则返回null
                System.out.println(completionService.take().get());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }

    public static void main(String[] args){
        new CompletionServiceDemo().run();
    }
}
