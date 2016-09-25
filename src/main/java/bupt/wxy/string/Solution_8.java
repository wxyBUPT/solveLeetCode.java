package main.java.bupt.wxy.string;

/**
 * Created by xiyuanbupt on 9/3/16.
 mplement atoi to convert a main.java.bupt.wxy.string to an integer.

 Hint: Carefully consider all possible input cases.
 If you want a challenge,
 please do not see below and ask yourself what are the possible input cases.

 */
public class Solution_8 {
    public int myAtoi(String str) {
        if(str==null || str.length()<=0) return 0;
        int res=0;
        int index=0;
        while(str.charAt(index)==' '){
            index++;
        }

        int sign=0;
        boolean isNegative=false;
        for(;index<str.length() && (sign<2);index++){
            char ch=str.charAt(index);
            int val=ch-48;
            if((ch=='+' || ch=='-')){
                sign++;
                if(ch=='-') isNegative=true;
                continue;
            }
            if((val>9 || val<0))
                break;
            if(!isNegative && res>(Integer.MAX_VALUE-val)/10)
                return Integer.MAX_VALUE;

            if(isNegative && ( res> (Integer.MAX_VALUE-val)/10))
                return Integer.MIN_VALUE;

            res=10*res+val;
        }

        if(isNegative)
            return res*-1;
        return res;
    }
}
