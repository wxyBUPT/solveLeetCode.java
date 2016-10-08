package bupt.wxy.sort;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/5/16.
 */
public class Solution_179 {
    public String largestNumber(int[] nums) {
        List<String> ques = new ArrayList<>();
        for (int num:nums
             ) {
            ques.add(Integer.toString(num));
        }
        Collections.sort(ques, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String num:ques
             ) {
            sb.append(num);
        }
        while (sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0)return "0";
        return sb.toString();
    }

    public static void main(String[] args){
        String s1 = "121";
        String s2 = "12";
        int[] ques = {1};
        Solution_179 sl = new Solution_179();
        String ans = sl.largestNumber(ques);
        System.out.println(ans);
        System.out.println(s1.compareTo(s2));
    }

}
