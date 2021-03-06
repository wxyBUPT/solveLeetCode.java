package bupt.wxy.math;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class Solution_168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n!=0){
            sb.insert(0,(char)('A' + (n-1)%26 ));
            n = (n-1) /26;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution_168 sl = new Solution_168();
        System.out.println(sl.convertToTitle(28));
    }
}
