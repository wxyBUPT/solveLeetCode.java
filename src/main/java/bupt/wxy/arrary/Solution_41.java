package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 10/11/16.
 * 利用下标
 */
public class Solution_41 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if(nums[i] == i + 1 || nums[i] <= 0 || nums[i]>nums.length){
                i++;
            }else if(nums[nums[i]-1] != nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
            else {
                i++;
            }

        }
        i = 0;
        while (i<nums.length && nums[i] == i+1){
            i++;
        }
        return i + 1;
    }
}
