package bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 9/29/16.
 */
public class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int end = numbers.length - 1;
        int start = 0;
        while (end>start){
            int sum = numbers[start] + numbers[end];
            if(sum>target){
                end--;
            }else if(sum<target){
                start ++;
            }else {
                break;
            }
        }
        int[] res = {start + 1,end + 1};
        return res;
    }
}
