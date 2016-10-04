package bupt.wxy.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 9/13/16.
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 */
public class MyQueue {

    /**
     * 使用两个栈实现队列的操作
     * 相对于使用队列实现栈时间复杂度好点
     */
    private List<Stack<Integer> > stacks = new ArrayList<>(2);

    public MyQueue(){
        stacks.add(new Stack<Integer>());
        stacks.add(new Stack<Integer>());
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stacks.get(0).push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> back = stacks.get(1);
        Stack<Integer> curr = stacks.get(0);
        if(back.isEmpty()){
            while (!curr.isEmpty()){
                back.push(curr.pop());
            }
        }
        back.pop();
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> back = stacks.get(1);
        Stack<Integer> curr = stacks.get(0);
        if(back.isEmpty()){
            while (!curr.isEmpty()){
                back.push(curr.pop());
            }
        }
        return back.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stacks.get(0).isEmpty() && stacks.get(1).isEmpty();
    }
}
