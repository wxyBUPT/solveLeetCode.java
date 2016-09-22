package hashtable;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Solution_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<int[]>(10,new Comparator<int[]>() {
            @Override
            public int compare(int[] q1, int[]q2) {
                return q2[1] - q1[1];
            }
        });

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        List<Integer> res = new ArrayList<>(k);
        for(int i = 0;i<k;i++){
            res.add(queue.poll()[0]);
        }
        return res;
    }

    public static void main(String[] args){
        Solution_347 sl = new Solution_347();
        int[] nums = {1,2};
        sl.topKFrequent(nums,2);
    }
}
