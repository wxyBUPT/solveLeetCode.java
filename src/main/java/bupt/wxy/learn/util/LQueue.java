package bupt.wxy.learn.util;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 9/16/16.
 * 在处理元素前用于保存元素的collections,除了基本的collection 操作之外,队列还提供其他的插入,提取和检查操作.
 * 每种都提供两种形式,一种抛出异常(操作失败的时候),另一种返回一个特殊值 null 或者false
 */
public class LQueue {
    Queue<Integer> queue = new ArrayDeque<>();

    private AbstractQueue<Integer> useAbQueue(){
        return null;
    }

    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.offer(2);
    }
}
