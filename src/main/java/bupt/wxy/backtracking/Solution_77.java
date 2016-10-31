package bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 10/31/16.
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

public class Solution_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curr = new ArrayList<>();
        combine(res,1,n,k,curr);
        return res;
    }

    void combine(List<List<Integer>> res, int s,int e,int k, List<Integer> curr){
        if((e-s + 1)<k)return;
        if(k==0){
            res.add(curr);
            return;
        }
        for(int i = s;i<=e;i++){
            List<Integer> next_curr = new ArrayList<>(curr);
            next_curr.add(i);
            combine(res,i+1,e,k-1,next_curr);
        }
    }
}
