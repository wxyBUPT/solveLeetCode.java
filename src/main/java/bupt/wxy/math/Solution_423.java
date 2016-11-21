package bupt.wxy.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiyuanbupt on 11/21/16.
 Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

 Note:
 Input contains only lowercase English letters.
 Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 Input length is less than 50,000.
 Example 1:
 Input: "owoztneoer"

 Output: "012"
 Example 2:
 Input: "fviefuro"

 Output: "45"
 */
public class Solution_423 {
    static String[] digits = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    public String originalDigits(String s){
        int[] count = new int[10];
        for(int i = 0;i<s.length();i++){
            char c= s.charAt(i);
            switch (c){
                case 'z':
                    count[0]++;
                    break;
                case 'w':
                    count[2]++;
                    break;
                case 'x':
                    count[6]++;
                    break;
                case 's':
                    count[7]++;
                    break;
                case 'g':
                    count[8]++;
                    break;
                case 'u':
                    count[4]++;
                    break;
                case 'f':
                    count[5]++;
                    break;
                case 'h':
                    count[3]++;
                    break;
                case 'i':
                    count[9]++;
                    break;
                case 'o':
                    count[1]++;
                    break;
                default:break;
            }
        }

        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
