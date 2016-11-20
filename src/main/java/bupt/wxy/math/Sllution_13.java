package bupt.wxy.math;

/**
 * Created by xiyuanbupt on 11/20/16.
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Sllution_13 {

    public int romanToInt(String s) {
        int num = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            switch (s.charAt(i)){
                case 'I':
                    num = (num < 5) ? num + 1 : num - 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num = (num < 50) ? num + 10 : num - 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num = (num < 500) ? num + 100 : num - 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    break;
            }
        }
        return num;
    }
}
