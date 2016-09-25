package main.java.bupt.wxy.arrary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/8/16.
 Given an array of integers and an integer k,
 find out whether there are two distinct indices i and j
 in the array such that nums[i] = nums[j]
 and the difference between i and j is at most k.
 */
public class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> table = new HashMap<>();
        Integer pos;
        for(int i = 0;i<nums.length;i++){
            pos = table.get(nums[i]);
            if(pos == null)table.put(nums[i],i);
            else {
                if(i - pos <= k)return true;
                else table.put(nums[i],i);
            }
        }
        return false;
    }
}
