package arrary;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 8/30/16.

 Write an efficient algorithm that searches for a value in an m x n matrix.
 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        /**
         *
         */
        if(matrix[0][0]>target)return false;
        if(matrix[len-1][0]<=target){
            if(Arrays.binarySearch(matrix[len-1],target)<0)return false;
            else return true;
        }

        int start = 0,end = len - 2;
        while (start<=end){
            int mid = (start+end)/2;
            if(matrix[mid][0]>target)end = mid-1;
            else {
                if(matrix[mid+1][0]>target){
                    int i = Arrays.binarySearch(matrix[mid], target);
                    if(i<0)return false;
                    else return true;
                }

                else start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution_74 solution_74 = new Solution_74();
        int[][] matrix =  {
        {1,   3,  5,  7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
        };
        int[][] matrix2 ={{1,},};
        boolean res = solution_74.searchMatrix(matrix,3);
        System.out.println(res);
        res = solution_74.searchMatrix(matrix2,1);
        System.out.println(res);
        int[] a = {1,};
    }
}
