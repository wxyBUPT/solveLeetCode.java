package bupt.wxy.engineering;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xiyuanbupt on 9/25/16.
 */
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();

        //创建十个并行任务并执行
        for(int i = 0;i<10;i++) {
            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }

        //遍历任务的结果
        for(Future<String> fs:resultList){
            try{
                while (!fs.isDone());
                System.out.println(fs.get());
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();

            }finally {
                //启动一次顺序关闭,执行当前提交任务,但是不接受新的任务
                executorService.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String>{

    public int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        /**
         * 是否添加sleep 对结果有很大的影响,不妨试一下
         */
        try{
            Thread.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("call() 方法被调用   " + Thread.currentThread().getName());

        //该返回结果被Future 的get 方法得到

        return "call() 方法被自动调用,任务返回的结果是 " + id + "   " + Thread.currentThread().getName();
    }
}