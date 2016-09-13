package stack;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/13/16.
 Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class MyStack {

    /**
     * 使用两个队列完成相应算法
     */
    List<Queue<Integer>> queues = new ArrayList<>(2);
    int curr;
    public MyStack(){
        queues.add(new ArrayDeque<Integer>());
        queues.add(new ArrayDeque<Integer>());
        /**
         * 设置一个当前队列,用于指向数据存放的地方
         */
        curr = 0;
    }
    // Push element x onto stack.
    public void push(int x) {
        queues.get(curr).offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int tmp = 0;
        Queue<Integer> now = queues.get(curr);
        Queue<Integer> future = queues.get((curr+1)%2);
        while (!now.isEmpty()){
            tmp = now.poll();
            if(!now.isEmpty())future.offer(tmp);
        }
        curr = (curr+1)%2;
    }

    // Get the top element.
    public int top() {
        int tmp = 0;
        Queue<Integer> now = queues.get(curr);
        Queue<Integer> future = queues.get((curr+1)%2);
        while (!now.isEmpty()){
            tmp = now.poll();
            future.offer(tmp);
        }
        curr = (curr+1)%2;
        return tmp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queues.get(curr).isEmpty();
    }

    public static void main(String[] args){
        MyStack myStack = new MyStack();
        myStack.push(1);
        int i = myStack.top();
        System.out.println(i);
        System.out.println(myStack.empty());
    }
}
