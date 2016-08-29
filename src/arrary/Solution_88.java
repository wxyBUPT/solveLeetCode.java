package arrary;

/**
 * Created by xiyuanbupt on 8/29/16.
 88. Merge Sorted Array

 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.

 */
public class Solution_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        /**
         * 复制到新的数组
         */
        for(int i = 0;i<m;i++){
            tmp[i] = nums1[i];
        }

        /**
         * 遍历两个数组
         */
        int i = 0,j=0;
        /**
         * 新的数组下标
         */
        int k = 0;
        while(i<m&&j<n){
            /**
             * 选两个数组中最小的元素添加到结果中
             */
            if(tmp[i]<=nums2[j]){
                nums1[k++] = tmp[i++];
            }
            else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i<m)nums1[k++] = tmp[i++];
        while (j<n)nums1[k++] = nums2[j++];
    }
}
