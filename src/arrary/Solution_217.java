package arrary;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 9/8/16.
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.
 */
public class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(visited.contains(nums[i])){
                return true;
            }else {
                visited.add(nums[i]);
            }
        }
        return false;
    }
}
