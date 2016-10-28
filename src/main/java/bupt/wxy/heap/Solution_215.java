package bupt.wxy.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 10/28/16.
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class Solution_215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1 );
        int min = Integer.MIN_VALUE;
        for(int num: nums){
            if(num>min || queue.size()<k){
                queue.offer(num);
                if(queue.size()>k)queue.poll();
                min = queue.peek();
            }
        }
        return queue.peek();
    }
}
