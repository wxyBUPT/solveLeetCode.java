package arrary;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/18/16.
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class Solution_55 {
    /**
     * 使用贪心算法,计算每一步能够达到的最远非零的位置
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        int len = nums.length;
        int curr = 0;
        while (curr < len){
            if(curr + nums[curr] >= nums.length-1)return true;
            if(nums[curr]==0)return false;
            int maxPoin = curr;
            int maxReach = curr + nums[curr];
            for(int i = 1;i<=nums[curr];i++){
                int tmp = curr + i + nums[curr + i];
                if(tmp>=maxReach){
                    maxPoin = curr + i;
                    maxReach = tmp;
                }
            }
            curr = maxPoin;
        }
        return true;
    }

    public static void main(String[] args){
        Solution_55 sl = new Solution_55();
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        sl.canJump(nums);
    }
}
