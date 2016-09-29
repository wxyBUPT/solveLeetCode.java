package bupt.wxy.engineering;

import java.util.concurrent.*;

/**
 * Created by xiyuanbupt on 9/25/16.
 */
public class LConcurrent {
    public static void main(String[] args){
        Executor executor = Executors.newCachedThreadPool();
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        Future future = completionService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "foo";
            }
        });
        try {
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        future = completionService.poll();
        try{
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        ConcurrentMap<Integer,Integer> concurrentMap = new ConcurrentHashMap<>();
    }
}
