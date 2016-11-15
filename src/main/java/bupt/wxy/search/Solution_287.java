package bupt.wxy.search;

/**
 * Created by xiyuanbupt on 11/15/16.
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 */

// 相关标签 Binary Search Array TwoPointers
public class Solution_287 {

    // 使用二分答案
    public int ofindDuplicate(int[] nums) {
        int min = 0,max = nums.length -1;
        while (min<=max){
            int mid = min + (max - min)/2;
            int cnt = 0;
            for(int a :nums){
                if(a<=mid)cnt++;
            }
            if(cnt>mid){
                max = mid -1;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }

    public int findDuplicate(int[] nums){
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);
        int find = 0;
        while (find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
