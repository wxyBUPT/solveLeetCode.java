package bupt.wxy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiyuanbupt on 10/24/16.
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */

// 使用桶排序
public class Solution_164 {

    

    // 下面的想法是自己规规矩矩的写桶排序
    public int maximumGap(int[] nums) {
        if(nums.length<2)return 0;
        List<Integer> res = new ArrayList<>();
        for(int i :nums){
            res.add(i);
        }
        List<Integer> sorted = bucketSort(res,10);
        System.out.println(sorted.toString());
        int maxGap = Integer.MIN_VALUE;
        int len = res.size();
        for(int i = 1;i<len;i++){
            maxGap = Math.max(maxGap,sorted.get(i) - sorted.get(i-1));
        }
        return maxGap;
    }

    private List<Integer> bucketSort(List<Integer> arr,int depth){
        if(arr.size()==0)return new ArrayList<>();
        if(depth==1){
            Collections.sort(arr);
            return arr;
        }
        List<List<Integer>> buckets = new ArrayList<>(10);
        for(int i = 0;i<10;i++){
            buckets.add(new ArrayList<Integer>());
        }
        int ibucket;
        for(Integer i:arr){
            ibucket = i;
            for(int d=0;d<depth;d++){
                ibucket /= 10;
            }
            buckets.get(ibucket % 10).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<10;i++){
            res.addAll(bucketSort(buckets.get(i),depth-1));
        }
        return res;
    }

    public static void main(String[] args){
        Solution_164 sl = new Solution_164();
        int[] nums = {1,10000000};
        sl.maximumGap(nums);
    }
}

