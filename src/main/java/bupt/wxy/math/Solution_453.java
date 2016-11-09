package bupt.wxy.math;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 11/9/16.
 Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Solution_453 {

    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }

    public static void main(String[] args){
        Solution_453 sl = new Solution_453();
        int[] nums = {-2147483648,-1};
        long res = sl.minMoves(nums);
        System.out.println(res);
    }

}
