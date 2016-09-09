package arrary;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/9/16.
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3,
 the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can,
 there are at least 3 different ways to solve this problem.
 */
public class Solution_189 {

    public void rotate(int[] nums, int k) {
        k = k %nums.length;
        int[] res = new int[nums.length];
        int i = 0;
        for( ;i<k;i++){
            res[i] = nums[nums.length-k+i];
        }
        for(;i<nums.length;i++){
            res[i] = nums[i-k];
        }
        for(i = 0;i<nums.length;i++){
            nums[i] = res[i];
        }
    }
}
