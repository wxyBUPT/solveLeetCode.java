package string;

/**
 * Created by xiyuanbupt on 9/9/16.
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Solution_67 {
    public String addBinary(String a, String b) {
        int i = 0;
        int len_a = a.length();
        int len_b = b.length();

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int a_c,b_c;
        int tmp ;
        while (i < len_a || i < len_b){
            if(i<len_a&&i<len_b){
                a_c = (int)a.charAt(len_a - 1 - i) - 48;
                b_c = (int)b.charAt(len_b - 1 - i) - 48;
                tmp = (a_c + b_c + carry)%2;
                if(tmp == 0){
                    sb.insert(0,'0');
                }else {
                    sb.insert(0,'1');
                }
                carry = (a_c + b_c + carry)/2;
            }else if(i<len_a){
                a_c = (int)a.charAt(len_a - i - 1) -48;
                tmp = (a_c + carry) %2;
                if(tmp == 0){
                    sb.insert(0,'0');
                }else {
                    sb.insert(0,'1');
                }
                carry = (a_c + carry)/2;
            }else {
                b_c = (int)b.charAt(len_b - i - 1) - 48;
                tmp = (b_c + carry) %2;
                if(tmp == 0){
                    sb.insert(0,'0');
                }else {
                    sb.insert(0,'1');
                }
                carry = (b_c + carry)/2;
            }
            i++;
        }
        if(carry == 1){
            sb.insert(0,'1');
        }
        return sb.toString();
    }

    public static void main(String[] args){
        char a = '1';
        char b = '0';
        System.out.println((int)b - 48);
    }
}
