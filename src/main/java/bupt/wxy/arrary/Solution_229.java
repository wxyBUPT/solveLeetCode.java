package bupt.wxy.arrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 11/15/16.
 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */

// 看到一种非常好的解法,摩尔投票法
public class Solution_229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int m = 0,n = 0,cm = 0,cn = 0;
        for(int a:nums){
            if(a == n)cn++;
            else if(a==m)cm++;
            else if(cm==0){
                m = a;
                cm = 1;
            }else if(cn == 0){
                n = a;
                cn = 1;
            }else {
                cn--;
                cm--;
            }
        }
        cn = 0 ;
        cm = 0;
        for(int a:nums){
            if(a==m)cm++;
            else if(a==n)cn++;
        }
        if(cm > nums.length/3)res.add(m);
        if(cn>nums.length/3)res.add(n);
        return res;

    }
}
