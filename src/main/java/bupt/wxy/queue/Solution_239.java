package bupt.wxy.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by xiyuanbupt on 10/11/16.
 */
public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0){
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        //用于记录结果
        int[] res = new int[len - k + 1];
        int r = 0;
        for(int i = 0;i<len;i++){
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);

            if(i>= k - 1){
                res[r ++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution_239 sl = new Solution_239();
        int[] ques = {1};
        int[] res = sl.maxSlidingWindow(ques,1);
        System.out.println(Arrays.toString(res));
    }
}
