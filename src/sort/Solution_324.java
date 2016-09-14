package sort;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/14/16.
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].


 */
public class Solution_324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = Arrays.copyOfRange(nums,0,nums.length);
        int mid = nums.length / 2;
        if(nums.length%2==1) {
            for (int i = 0; i <= mid; i++) {
                nums[2 * i] = tmp[mid - i];
            }
            for(int i = 1;i<=mid;i++){
                nums[2*i+1] = tmp[nums.length-i];
            }
        }
        else {
            for(int i = 0;i<mid;i++){
                nums[2*i] = tmp[mid-i-1];
                nums[2*i+1] = tmp[nums.length -i-1];
            }
        }
    }
    public static void main(String[] args){
        int[] nums = {4,5,5,6};
        Solution_324 sl = new Solution_324();
        sl.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
