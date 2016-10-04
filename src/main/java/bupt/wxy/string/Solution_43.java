package bupt.wxy.string;

/**
 * Created by xiyuanbupt on 9/10/16.
 Given two numbers represented as strings,
 return multiplication of the numbers as a main.java.bupt.wxy.string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input main.java.bupt.wxy.string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.
 */
public class Solution_43 {

    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1<= len2)return multi(num2,num1);
        else return multi(num1,num2);
    }

    private String multi(String num1,String num2){
        int len2 = num2.length();
        String res = "";
        for (int i = 0;i<len2;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(multiply(num1,num2.charAt(len2 - i -1)));
            for(int j = 0;j<i;j++)sb.append("0");
            res = sum2String(res,sb.toString());
        }
        while (res.startsWith("0") && res.length()>0){
            res = res.substring(1);
        }
        return res;
    }

    /**
     * 将两个string 的结果相加
     * @param num1
     * @param num2
     * @return
     */
    private String sum2String(String num1,String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0;
        while (i<len1&&i<len2){
            int i1 = num1.charAt(len1-i-1) - '0';
            int i2 = num2.charAt(len2-i-1) - '0';
            sb.insert(0,(i1+i2+carry)%10);
            carry = (i1+i2+carry)/10;
            i++;
        }
        while (i<len1){
            int i1 = num1.charAt(len1-i-1) - '0';
            sb.insert(0,(i1+carry)%10);
            carry = (i1 + carry)/10;
            i++;
        }
        while (i<len2){
            int i2 = num2.charAt(len2-i-1) - '0';
            sb.insert(0,(i2+carry)%10);
            carry = (i2+carry)/10;
            i++;
        }
        if(carry!=0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    /**
     * 讲一个字符串与一个字符相乘
     * @param num1
     * @param c
     * @return
     */
    private String multiply(String num1,Character c){
        int carry = 0;
        int s = c - '0';
        int len = num1.length();
        StringBuilder sb = new StringBuilder();
        int value ;
        for(int i = 0;i<len;i++){
            value = num1.charAt(len-i-1) - '0';
            value = s * value + carry;
            sb.insert(0,value%10);
            carry = value/10;
        }
        if(carry!=0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution_43 sl = new Solution_43();
        String num1 = "123";
        String num2 = "238";
        System.out.println(sl.multiply(num1,num2));
    }

}
