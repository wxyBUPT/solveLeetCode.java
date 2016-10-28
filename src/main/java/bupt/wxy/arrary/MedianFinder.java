package bupt.wxy.arrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xiyuanbupt on 10/28/16.
 */
public class MedianFinder {

    private PriorityQueue<Integer> max = new PriorityQueue<>();
    private PriorityQueue<Integer> min = new PriorityQueue<>(1000, Collections.reverseOrder());

    // Adds a number into the data structure.

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size()<min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(max.size()==min.size())return (max.peek() + min.peek())/2.0;
        return max.peek();
    }
}
