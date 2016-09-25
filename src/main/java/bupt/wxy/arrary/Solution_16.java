package bupt.wxy.arrary;

import java.util.*;

/**
 * Created by xiyuanbupt on 8/29/16.
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 target. Return the sum of the three integers.
 You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution_16 {

    /**
     * 时间复杂度比较高的算法
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer,List<List<Integer>>> cache = new HashMap<>();
        for(int i = 0;i<nums.length;){
            for(int j = nums.length - 1;j>i;){
                int sum = nums[i] + nums[j];
                List<Integer> point = new ArrayList<>(2);
                point.add(i);
                point.add(j);
                if(!cache.containsKey(sum)){
                    cache.put(sum,new ArrayList<List<Integer>>());
                }
                cache.get(sum).add(point);
                while (j>i+1&&nums[j] == nums[j-1])j--;
                j--;
            }
            while (i<nums.length-1&&nums[i]==nums[i+1])i++;
            i++;
        }

        int res = 0;

        /**
         * 逐个查找是否有最小的结果
         */
        for(int i = 0;i<Integer.MAX_VALUE;i++){
            res = target + i;
            for(Map.Entry<Integer,List<List<Integer>>> entry:cache.entrySet()){
                for(List<Integer> point : entry.getValue()){
                    int start = point.get(0);
                    int end = point.get(1);
                    if(Arrays.binarySearch(nums,start+1,end,res-entry.getKey())>=0)return res;
                }
            }

            res = target - i;
            for(Map.Entry<Integer,List<List<Integer>>> entry:cache.entrySet()){
                for(List<Integer> point : entry.getValue()){
                    int start = point.get(0);
                    int end = point.get(1);
                    if(Arrays.binarySearch(nums,start+1,end,res-entry.getKey())>=0)return res;
                }
            }
        }
        return res;
    }

    public int ithreeSumClosest(int[] nums, int target) {

        if(nums.length<=2)return -1;
        Arrays.sort(nums);
        int min_dist = Integer.MAX_VALUE;
        int dist;
        int curr_sum = 0;
        int best_result = 0;
        for(int i = 0; i<nums.length-2;i++){
            /**
             * 确定单点
             */
            int k = i + 1;
            int j = nums.length - 1;

            while (k<j){
                curr_sum = nums[i] + nums[j] + nums[k];
                dist = curr_sum - target;
                /**
                 * 此时代表结果大于预期
                 */
                if(dist>0){
                    /**
                     * 如果当前是最小点,则更新最小点
                     */
                    if(dist<min_dist){
                        min_dist = dist;
                        best_result = curr_sum;
                    }
                    /**
                     * 避免相同值的判断
                     */
                    while(j>k+1&&nums[j]==nums[j-1])j--;
                    j--;
                }
                else if(dist<0){
                    if(-dist<min_dist){
                        min_dist = -dist;
                        best_result = curr_sum;
                    }
                    while (k<j-1&&nums[k]==nums[k+1])k++;
                    k++;
                }else {
                    return curr_sum;
                }
            }
        }
        return best_result;


    }


    public static void main(String[] args){
        Solution_16 solution_16 = new Solution_16();
        int[] ques = {-1,2,1,-4};
        int res = solution_16.ithreeSumClosest(ques,1);
        System.out.println(res);
    }
}
