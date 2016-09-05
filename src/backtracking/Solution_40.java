package backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/4/16.
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class Solution_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates.length==0)return res;
        int len = 0;
        for(;len<candidates.length && candidates[len]<=target;len++){

        }
        candidates = Arrays.copyOfRange(candidates,0,len);
        helper(candidates,target,new ArrayList<Integer>(),0,res);
        return res;
    }

    private void helper(int[] candidates,int target,List<Integer> curr,int start,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0)return;
        for(int i = start;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[i-1])continue;
            /**
             * 对应选这个的情况
             */
            curr.add(candidates[i]);
            helper(candidates,target-candidates[i],curr,i+1,res);
            curr.remove(curr.size()-1);
        }
    }



    public static void main(String[] args){
        Solution_40 solution_40 = new Solution_40();
        int[] ques = {10,1,2,7,6,1,5};
        List<List<Integer>> res = solution_40.combinationSum2(ques,8);
        System.out.println(res);
    }

}
