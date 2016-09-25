package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_91 {

    public int numDecodings(String s) {
        return 1;
    }

    private boolean isValid(String s,int start,int end){
        if(start == end){
            char c = s.charAt(start);
            if('1'<=c && c<='9')return true;
            else return false;
        }
        /**
         * 假定所有情况合法
         */
        else {
            char a = s.charAt(start);
            if(a=='1')return true;
            else if(a=='2') {
                char b = s.charAt(end);
                if(b<='6')return true;
                else return false;
            }else {
                return false;
            }
        }
    }
}
