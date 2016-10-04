package bupt.wxy.arrary;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 8/31/16.
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class Solution_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0]>target)return false;
            else {
                if(Arrays.binarySearch(matrix[i],target)<0)continue;
                else return true;
            }
        }
        return false;
    }
}
