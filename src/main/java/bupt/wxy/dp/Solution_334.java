package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/29/16.
 */
public class Solution_334 {
    public boolean increasingTriplet(int[] nums) {
        /**
         * 用于记录之前的增序序列
         */
        if(nums.length<3)return false;
        int min = nums[0];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        //首先找到两个元素之间互相增序排列
        int i = 1;
        for(;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }else if(nums[i]==min){

            }else if(nums[i] <= first){
                if(nums[i]==first&&first==min){
                    continue;
                }
                first = min;
                second = nums[i];
            }else if(nums[i]<=second){
                if(nums[i]==second)continue;
                if(min==first){
                    second = nums[i];
                }else {
                    second = first;
                    first = min;
                }
            }else {
                System.out.println(first + " " + second + " " + min + " " + nums[i]);
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        int[] ans = {2,1,5,0,3};
        Solution_334 sl = new Solution_334();
        boolean res = sl.increasingTriplet(ans);
        System.out.println(res);
    }
}
