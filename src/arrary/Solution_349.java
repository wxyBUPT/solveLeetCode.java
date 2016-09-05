package arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        int pre = Integer.MIN_VALUE;
        List<Integer> tmp = new ArrayList<>();
        while (i1<nums1.length&&i2<nums2.length){
            if(nums1[i1]==nums2[i2]){
                if(nums1[i1]!=pre) {
                    tmp.add(nums1[i1]);
                    pre = nums1[i1];
                }
                i1++;
                i2++;
            }
            else if(nums1[i1]>nums2[i2])i2++;
            else i1++;
        }
        int[] res = new int[tmp.size()];
        for(int i =0;i<tmp.size();i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
}
