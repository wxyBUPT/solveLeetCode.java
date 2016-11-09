package bupt.wxy.arrary;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 11/9/16.
 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class Solution_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if(nums.length==0)return res;

        int i = 0;
        for(int j = 1;j<nums.length;){
            while (j<nums.length && nums[j-1] + 1 == nums[j])j++;
            if(j-1==i){
                res.add(nums[i]+ "");
            }else {
                res.add(nums[i] + "->" + nums[j - 1]);
            }
            i = j;
            j = i+1;
        }
        if(i==nums.length-1)res.add(nums[i] + "");
        return res;
    }

    public static void main(String[] args){
        Solution_228 sl = new Solution_228();
        int[] nums = {0,1};
        List<String> res = sl.summaryRanges(nums);
        for(String s:res){
            System.out.println(s);
        }
    }
}
