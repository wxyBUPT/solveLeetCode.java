package arrary;

/**
 * Created by xiyuanbupt on 8/30/16.
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class Solution_153 {
    /**
     * 二分查找问题
     * 思想有点类似于减掉有序的
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return findMin(nums,0,nums.length-1);
    }

    private int findMin(int[] nums,int start,int end){
        if(start == end)return nums[start];
        /**
         * 两个元素特殊处理,需要判断是否可以被覆盖
         */
        if(start+1==end)return Math.min(nums[start],nums[end]);
        int mid = (start+end)/2;

        if(nums[mid]<nums[end]&&nums[mid]>nums[start]){
            return findMin(nums,start,mid);
        }else if(nums[mid]>nums[end]&&nums[mid]>nums[start]){
            return findMin(nums,mid,end);
        }else if(nums[mid]<nums[start]&&nums[mid]<nums[end]){
            return findMin(nums,start,mid);
        }else return -1;
    }

    /**
     * 非递归算法
     * @param nums
     * @return
     */
    public int findMind(int[] nums){
        if(nums.length==0)return -1;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.min(nums[0],nums[1]);
        int start = 0;
        int end = nums.length-1;
        while(start<end-1){
            if(nums[start]<nums[end])return nums[start];
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[start]){start = mid;}else if(nums[mid]<nums[end]){
                end = mid;
            }

        }
        /**
         * 当两个元素的时候
         */
        return Math.min(nums[start],nums[end]);
    }


    public static void main(String[] args){
        Solution_153 solution_153 = new Solution_153();
        int[] nums = {5,1,2,3,4};
        int res = solution_153.findMin(nums);
        System.out.println(res);
    }
}
