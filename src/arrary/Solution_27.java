package arrary;

/**
 * Created by xiyuanbupt on 8/26/16.
 *
 27. Remove Element  QuestionEditorial Solution  My Submissions
 Total Accepted: 138231
 Total Submissions: 390686
 Difficulty: Easy
 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */

public class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        /**
         * 当前访问到的位置
         */
        int visitPoint = 0;
        /**
         * 放置当前数字的位置
         */
        int currentPoint = 0;
        for(;visitPoint<len;visitPoint++){
            if(nums[visitPoint]!=val){
                nums[currentPoint++] = nums[visitPoint];
            }
        }
        return currentPoint;
    }

    public static void main(String[] args){
        Solution_27 solution_27 = new Solution_27();
        int[] nums = {3,2,2,3};
        int i = solution_27.removeElement(nums,3);
        System.out.println(i);

        for(int j : nums){
            System.out.println(j);
        }
    }
}
