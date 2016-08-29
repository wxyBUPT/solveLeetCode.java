package arrary;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 8/26/16.
 *

 66. Plus One  QuestionEditorial Solution  My Submissions

 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 */
public class Solution_66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        /**
         * 表示前面的进位
         */
        int result = 1;
        int tmp = 0;
        for(int i = len-1;i>=0;i--){
            tmp = digits[i];
            digits[i] = (digits[i] + result) % 10;
            result = (tmp + result)/10;
        }
        /**
         * 进位完毕,当增加了一位结果的时候
         */
        if(result!=0){
            int[] res = new int[len+1];
            res[0] = result;
            for(int i = 0;i<len;i++){
                res[1+i] = digits[i];
                return res;
            }
        }else {
            return digits;
        }
        return null;
    }

    public static void main(String[] args){
        Solution_66 solution_66 = new Solution_66();
        int[] digits = {9};
        digits = solution_66.plusOne(digits);
        for(int i : digits){
            System.out.println(i);
        }
    }
}
