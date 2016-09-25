package bupt.wxy.arrary;

import java.util.*;

/**
 * Created by xiyuanbupt on 8/30/16.
 *
 Given an array S of n integers, are there elements a, b, c,
 and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class Solution_18 {

    /**
     * 实现思想:
     * On * On^2 时间复杂度
     * 用HashMap保存外层结果
     *
     * 本想法Timelimit out
     * 时间复杂度近似 on^3
     * 并且边界条件也想的不是很好
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int sum ;
        Map<Integer,List<List<Integer>>> cache = new HashMap<>();
        for(int i = 0;i<nums.length-2;){
            for(int j = nums.length-1;j>i+2;){
                sum = nums[i] + nums[j];
                if(!cache.containsKey(sum))cache.put(sum,new LinkedList<List<Integer>>());
                List<Integer> point = new ArrayList<>(2);
                point.add(i);
                point.add(j);
                cache.get(sum).add(point);

                /**
                 * 取消掉重复
                 */
                while (j>i+2&&nums[j-1]==nums[j])j--;
                j--;
            }
            /**
             * 取消掉重复点
             */
            while (i<nums.length-2&&nums[i+1]==nums[i])i++;
            i++;
        }
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 对预处理的数据遍历
         */
        for(Map.Entry<Integer,List<List<Integer>>> entry:cache.entrySet()){
            List<List<Integer>> points = entry.getValue();
            int sure = target-entry.getKey();
            int tmpSum;
            for(List<Integer> point : points){
                for(int i = point.get(0)+1;i<point.get(1)-1;){
                    for(int j = point.get(1)-1;j>i;){
                        tmpSum = nums[i] + nums[j];
                        if(tmpSum == sure){
                            List<Integer> resElement = new ArrayList<>();
                            resElement.add(nums[point.get(0)]);
                            resElement.add(nums[i]);
                            resElement.add(nums[j]);
                            resElement.add(nums[point.get(1)]);
                            result.add(resElement);
                        }
                        while (j>i+1&&nums[j]==nums[j-1])j--;
                        j--;
                    }
                    while (i<point.get(1) - 2 && nums[i]==nums[i+1])i++;
                    i++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fouriSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int sum ;

        for(int i = 0;i<nums.length-3;){

            for(int j = i+1;j<nums.length-2;){

                int l = nums.length-1;
                int k = j + 1;
                while (k<l){
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    int dis = sum - target;
                    if(dis>0){
                        while (l>k+1&&nums[l]==nums[l-1])l--;
                        l--;
                    }
                    else if(dis<0){
                        while (k<l-1&&nums[k]==nums[k+1])k++;
                        k++;
                    }else {
                        /**
                         * 找到结果
                         */
                        List<Integer> resEle = new ArrayList<>(4);
                        resEle.add(nums[i]);
                        resEle.add(nums[j]);
                        resEle.add(nums[k]);
                        resEle.add(nums[l]);
                        res.add(resEle);

                        while (l>k+1&&nums[l]==nums[l-1])l--;
                        l--;

                    }
                }
                /**
                 * 略过重复的元素
                 */
                while (j<nums.length-2&&nums[j]==nums[j+1])j++;
                j++;
            }

            /**
             * 略过重复元素
             */
            while (i<nums.length-3&&nums[i]==nums[i+1])i++;
            i++;
        }
        return res;
    }



    public static void main(String[] args){
        Solution_18 solution_18 = new Solution_18();
        int[] S = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = solution_18.fouriSum(S,0);
        System.out.print(res);
    }

}
