package bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 10/21/16.
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Solution_78 {

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> chose = new ArrayList<>();
        chose.add(nums[0]);
        List<Integer> giveup = new ArrayList<>();
        backtrack(res,chose,nums,1);
        backtrack(res,giveup,nums,1);
        return res;
    }

    private void backtrack(List<List<Integer>> res ,List<Integer> curr,int[] nums, int index){
        if(index == nums.length)res.add(curr);
        else {
            List<Integer> chose = new ArrayList<>(curr);
            chose.add(nums[index]);
            backtrack(res,chose,nums,index+1);
            List<Integer> giveup = new ArrayList<>(curr);
            backtrack(res,giveup,nums,index + 1);
        }
    }
}
