package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 9/10/16.
 Given n non-negative integers a1, a2, ...,
 an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of
 line i is at (i, ai) and (i, 0). Find two lines,
 which together with x-axis forms a container,
 such that the container contains the most water.
 */

/**
 * 两点之中小的向中间前进,大的不动
 */
public class Solution_11 {
    public int maxArea(int[] height) {
        int maxSize = Integer.MIN_VALUE;
        int h;
        int w;
        int size;
        int i = 0,j = height.length-1;
        while (i<j){
            if(height[i]<height[j]){
                h = height[i];
                w = j - i;
                size = h * w;
                maxSize = maxSize > size?maxSize:size;
                while (i<j&&height[i+1]<=h)i++;
                i++;
            }else {
                h = height[j];
                w = j - i;
                size = h * w;
                maxSize = maxSize>size?maxSize:size;
                while (j>i&&height[j-1]<=h)j--;
                j--;
            }
        }
        return maxSize;
    }

    public static void main(String[] args){
        Solution_11 so = new Solution_11();
        int[] height = {1,2,};
        so.maxArea(height);
    }
}
