package bupt.wxy.arrary;

import java.util.*;

/**
 * Created by xiyuanbupt on 8/29/16.
 15. 3Sum  QuestionEditorial Solution  My Submissions
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Solution_15 {
    /**
     * two pointers 问题
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 对要处理的数组排序
         * 能够预处理的数据尽量预处理
         * 避免需要多次吹
         */
        Arrays.sort(nums);
        Map<Integer,List<List<Integer>>> cache = new HashMap<>();
        /**
         * 两点遍历
         */
        for(int i = 0;i<nums.length;){
            for(int j = nums.length-1;i<j;){
                int sum = nums[i] + nums[j];
                List<Integer> point = new ArrayList<>(2);
                point.add(i);
                point.add(j);
                if(!cache.containsKey(0-sum)){
                    cache.put(0-sum,new ArrayList<List<Integer>>());
                }
                cache.get(0-sum).add(point);
                while (j>i+1&&nums[j]==nums[j-1])j--;
                j--;
            }
            while (i<nums.length-1&&nums[i+1]==nums[i])i++;
            i++;
        }
        List<List<Integer>> res = new ArrayList<>();

        for(Map.Entry<Integer,List<List<Integer>>> entry: cache.entrySet() ){
            for(List<Integer> point:entry.getValue()){
                int midPoint = Arrays.binarySearch(nums,point.get(0)+1,point.get(1),entry.getKey());

                if(midPoint>=0){
                    List<Integer> tmpRes = new ArrayList<>(3);
                    tmpRes.add(nums[point.get(0)]);
                    tmpRes.add(entry.getKey());
                    tmpRes.add(nums[point.get(1)]);
                    res.add(tmpRes);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution_15 solution_15 = new Solution_15();
        int[] answer = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution_15.threeSum(answer);
        for(List<Integer> r:result){
            System.out.println(r);
        }
    }
}
