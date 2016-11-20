package bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 11/20/16.
 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Solution_402 {

    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k>0){
            int len = sb.length();
            for(int i = 0;i<len - 1;i++){
                if(sb.charAt(i) > sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    k--;
                    break;
                }
            }
            if(sb.length()==len){
                sb.deleteCharAt(len-1);
                k--;
            }
        }
        while (sb.length()>0 &&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0":sb.toString();
    }

    public static void main(String[] args){
        Solution_402 sl = new Solution_402();
        StringBuilder sb = new StringBuilder("123");
        for(int i = 0;i<3;i++){
            sb.deleteCharAt(0);
            System.out.println(sb.length());
        }
    }
}
