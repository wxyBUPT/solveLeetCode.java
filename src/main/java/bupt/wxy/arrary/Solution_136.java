package bupt.wxy.arrary;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Solution_136 {

    public int singleNumber(int[] nums) {
        Set<Integer> single = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            if(single.contains(nums[i])){
                single.remove(nums[i]);
            }else {
                single.add(nums[i]);
            }
        }
        for(int i : single){
            System.out.println(i);
            return i;
        }
        return 0;
    }
}
