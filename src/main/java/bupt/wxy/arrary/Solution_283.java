package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given an array nums, write a function to move all 0's to the
 end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12],
 after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class Solution_283 {

    public void moveZeroes(int[] nums) {
        int zCount = 0;
        int len = nums.length;
        int pos = 0;
        for(;pos<len;pos++){
            if(nums[pos]==0)zCount++;
            else {
                nums[pos-zCount] = nums[pos];
            }
        }
        pos = len - zCount;
        for(;pos<len;pos++){
            nums[pos] = 0;
        }
    }
}
