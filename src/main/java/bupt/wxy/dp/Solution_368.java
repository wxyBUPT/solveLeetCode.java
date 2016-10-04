package bupt.wxy.dp;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/12/16.
 Given a set of distinct positive integers,
 find the largest subset such that every pair
 (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]
 */
public class Solution_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0)return new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Set<Integer>> resMap = new HashMap<>(nums.length);
        for(int i = 0;i<nums.length;i++){
            int max = Integer.MIN_VALUE;
            Set<Integer> currMax = new HashSet<>();
            for(Map.Entry<Integer,Set<Integer>> entry:resMap.entrySet()){
                if(nums[i] % entry.getKey()==0){
                    if(entry.getValue().size()>max){
                        currMax = entry.getValue();
                        max = currMax.size();
                    }
                }
            }
            Set<Integer> tmp = new HashSet<>(currMax);
            tmp.add(nums[i]);
            resMap.put(nums[i],tmp);
        }
        Set<Integer> res = Collections.max(resMap.values(), new Comparator<Set<Integer>>() {
            @Override
            public int compare(Set<Integer> o1, Set<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        return new ArrayList<>(res);
    }

    public static void main(String[] args){
        Solution_368 sl = new Solution_368();
        int[] nums = {1,2,3};
        System.out.println(sl.largestDivisibleSubset(nums));
    }
}
