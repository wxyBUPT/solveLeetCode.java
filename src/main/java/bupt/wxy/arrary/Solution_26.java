package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 8/26/16.
 *
 * 26. Remove Duplicates from Sorted Array  QuestionEditorial Solution  My Submissions
 Total Accepted: 151455
 Total Submissions: 439523
 Difficulty: Easy
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2,
 with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        /**
         * 当前数组的长度
         */
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        /**
         * 数组被访问到的位置
         */
        int arrPos = 0;
        /**
         * 新的数组位置
         */
        int resPos = 0;
        for(;arrPos<len;arrPos++){
            /**
             * 当前位置的结果不相同
             */
            if(nums[arrPos]!=nums[resPos]){
                nums[++resPos] = nums[arrPos];
            }
        }
        /**
         * 返回新的数组的长度
         */
        return resPos+1;
    }
}
