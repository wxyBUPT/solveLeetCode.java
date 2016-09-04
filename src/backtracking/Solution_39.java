package backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/4/16.
 Given a set of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */

/**
 * 有点类似于背包问题
 */
public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0)return res;
        int len = 0;
        for(;len<candidates.length && candidates[len]<=target;len++){

        }
        candidates = Arrays.copyOfRange(candidates,0,len);
        helper(candidates,target,new ArrayList<Integer>(),res,0);
        return new ArrayList<>(res);
    }

    private void helper(int[] candidates,int target, List<Integer> curr,List<List<Integer>> res,int start){
        if(target==0){
            Collections.sort(curr);
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0)return;
        for(int i = start;i<candidates.length;i++){
            curr.add(candidates[i]);
            helper(candidates,target-candidates[i],curr,res,i);
            curr.remove(curr.size()-1);
        }
        /**
         * 移除最后一个元素
         */
    }

    public static void main(String[] args){
        Solution_39 solution_39 = new Solution_39();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = solution_39.combinationSum(candidates,7);
        System.out.println(res);
    }
}
