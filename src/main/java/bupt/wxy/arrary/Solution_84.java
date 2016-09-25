package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 8/30/16.
 *
 因为有图,所以题目不全,题目连接在 https://leetcode.com/problems/largest-rectangle-in-histogram/
 84. Largest Rectangle in Histogram  QuestionEditorial Solution  My Submissions
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.

 本题给人的第一感觉是动态规划
 */
public class Solution_84 {

    /**
     * On^2 的算法,超时
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int maxSize = 0;
        for(int i =  0;i<heights.length;i++){
            int currentMin = heights[i];
            for(int j = i;j<heights.length;j++){
                currentMin = currentMin<heights[j]?currentMin:heights[j];
                int currentSize = currentMin*(j-i+1);
                maxSize = currentSize>maxSize?currentSize:maxSize;
            }
        }
        return maxSize;
    }


    public static void main(String[] args){
        Solution_84 solution_84 = new Solution_84();
        int[] ans = {2,1,5,6,2,3};
        int res = solution_84.largestRectangleArea(ans);
        System.out.println(res);
    }
}
