package bupt.wxy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiyuanbupt on 10/31/16.
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Solution_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remain = Arrays.stream(nums).boxed().collect(Collectors.<Integer>toList());
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        permute(res,remain,curr);
        return res;

    }

    void permute(List<List<Integer>> res , List<Integer> remain,List<Integer> curr){
        if(remain.size()==0)res.add(curr);
        int len = remain.size();
        for(int i = 0;i<len;i++){
            List<Integer> next_curr = new LinkedList<>(curr);
            next_curr.add(remain.get(i));
            List<Integer> next_remain = new ArrayList<>(remain);
            next_remain.remove(i);
            permute(res,next_remain,next_curr);
        }
    }
}
