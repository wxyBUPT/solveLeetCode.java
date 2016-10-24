package bupt.wxy.arrary;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/24/16.
 Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.

 Example:

 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);

 // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 solution.pick(3);

 // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 solution.pick(1);
 */

class Solution_398{

}

class Solution{

    Map<Integer,List<Integer>> map;
    private Random randomGenerator;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.get(num).add(i);
            }else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(num,tmp);
            }
        }
        randomGenerator = new Random();
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int index = randomGenerator.nextInt(list.size());
        return list.get(index);
    }
}
