package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 10/28/16.
 Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution_415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        while (l1>=0&&l2>=0){
            int x = Character.getNumericValue(num1.charAt(l1--));
            int y = Character.getNumericValue(num2.charAt(l2--));
            sb.insert(0,(x+y + carry)%10);
            carry = (x+y+carry)/10;
        }
        while (l1>=0){
            int x = Character.getNumericValue(num1.charAt(l1--));
            sb.insert(0,(x+carry)%10);
            carry = (x+carry)/10;
        }
        while (l2 >= 0){
            int x = Character.getNumericValue(num2.charAt(l2--));
            sb.insert(0,(x+carry)%10);
            carry = (x+carry)/10;
        }
        if(carry!=0)sb.insert(0,carry);
        return sb.toString();
    }
}
