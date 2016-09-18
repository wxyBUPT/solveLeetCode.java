package dp;

/**
 * Created by xiyuanbupt on 9/18/16.
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class Solution_152 {
    public int maxProduct(int[] nums) {
        if(nums.length==0)return nums[0];
        int[] leftMax = new int[nums.length];
        int[] midPosMax = new int[nums.length];
        int[] midNegMax = new int[nums.length];
        leftMax[0] = nums[0];
        if(nums[0]>0){
            midPosMax[0] = nums[0];
            midNegMax[0] = 0;
        }
        else {
            midPosMax[0] = 0;
            midNegMax[0] = nums[0];
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[i]==0){
                midPosMax[i] = 0;
                midNegMax[i] = 0;
                leftMax[i] = leftMax[i-1]>0?leftMax[i-1]:0;
            }else if(nums[i]<0){
                midNegMax[i] = midPosMax[i-1] == 0 ?nums[i]:midPosMax[i-1] * nums[i];
                midPosMax[i] = midNegMax[i-1] * nums[i];
                leftMax[i] = Math.max(midPosMax[i],leftMax[i-1]);
            }else {
                midNegMax[i] = midNegMax[i-1] * nums[i];
                midPosMax[i] = midPosMax[i-1]==0?nums[i]:midPosMax[i-1] * nums[i];
                leftMax[i] = Math.max(midPosMax[i],leftMax[i-1]);
            }
        }
        return leftMax[nums.length-1];
    }

    public int sim(int[] nums){
        if(nums.length==1)return nums[0];
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            min[i] = Math.min(Math.min(max[i-1] * nums[i],min[i-1] * nums[i]),nums[i]);
            max[i] = Math.max(Math.max(max[i-1] * nums[i],min[i-1] * nums[i]),nums[i]);
            res = Math.max(max[i],res);
        }
        return res;
    }

    public static void main(String[] args){
        Solution_152 sl = new Solution_152();
        int[] nums = {0,2};
        sl.maxProduct(nums);
    }
}
