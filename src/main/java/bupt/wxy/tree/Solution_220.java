package bupt.wxy.tree;

import java.util.TreeSet;

/**
 * Created by xiyuanbupt on 10/20/16.
 */
public class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            Integer ceil = treeSet.ceiling(nums[i] - t);
            Integer floor = treeSet.floor(nums[i] + t);
            if(ceil!= null && ceil <= nums[i]||floor!=null && floor>=nums[i])return true;
            treeSet.add(nums[i]);
            if(i >= k){
                treeSet.remove(nums[i-k]);
            }
        }
        return false;
    }
}
