package bupt.wxy.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiyuanbupt on 11/20/16.
 Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 Example 1:
 Input: [ [1,2], [2,3], [3,4], [1,3] ]

 Output: 1

 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 Example 2:
 Input: [ [1,2], [1,2], [1,2] ]

 Output: 2

 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 Example 3:
 Input: [ [1,2], [2,3] ]

 Output: 0

 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution_435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start!=o2.start)return o1.start - o2.start;
                int d1 = o1.end - o1.start;
                int d2 = o2.end - o2.start;
                return d1 - d2;
            }
        });

        int end = Integer.MIN_VALUE;
        int rmCount = 0;
        for(Interval interval:intervals){
            if(interval.start<end)rmCount++;
            else {
                end = interval.end;
            }
        }
        return rmCount;
    }
}
