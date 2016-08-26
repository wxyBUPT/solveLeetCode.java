package arrary;

/**
 * Created by xiyuanbupt on 8/26/16.
 *
 上接 26 题
 题意是在 26 题目的基础上允许重复两次
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5,
 with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.
 */
public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        /**
         * 每个数字允许的最多的重复次数
         */
        int reCount = 1;
        /**
         * 存储结果的位置
         */
        int resPos = 0;
        /**
         * 数组被访问到的位置
         */
        int arrPos = 1;
        for(;arrPos<nums.length;++arrPos){
            /**
             * 如果没有出现重复
             */
            if(nums[resPos]!=nums[arrPos]){
                /**
                 * 重置当前允许出现重复的次数
                 */
                resPos++;
                reCount = 1;
                nums[resPos] = nums[arrPos];
            }
            /**
             * 如果相等
             */
            else {
                if(reCount==0){

                }
                else {
                    resPos++;
                    nums[resPos] = nums[arrPos];
                    reCount --;
                }
            }
        }
        return resPos + 1;
    }
}
