package bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/5/16.
 Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(k,n,curr,res,1);
        return res;
    }

    private void helper(int k,int n , List<Integer> curr,List<List<Integer>> res ,int start){
        if(n == 0 && k == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(n==0 || k == 0)return;
        for(int i = start;i<10;i++){
            curr.add(i);
            helper(k-1,n-i,curr,res,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
