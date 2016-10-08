package bupt.wxy.backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/8/16.
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Solution_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> rst = new HashSet<>();
        dfs(rst,new ArrayList<Integer>(),0,nums);
        return new ArrayList<>(rst);
    }

    private void dfs(Set<List<Integer>> rst,List<Integer> path,int start,int[] nums){
        if(start == nums.length){
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        int len = path.size();

        path.add(nums[start]);
        dfs(rst,path,start+1,nums);
        for(int i = len;i<path.size();i++){
            path.remove(i);
        }

        dfs(rst,path,start+1,nums);
        for(int i = len;i<path.size();i++){
            path.remove(i);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,2};
        Solution_90 sl = new Solution_90();
        List<List<Integer>> res = sl.subsetsWithDup(nums);
        for(List<Integer> list:res){
            System.out.println(list.toString());
        }
    }
}
