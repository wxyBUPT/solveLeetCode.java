package main.java.bupt.wxy.string;

/**
 * Created by xiyuanbupt on 9/10/16.
 Write a function to find the longest common prefix main.java.bupt.wxy.string amongst an array of strings.


 */
public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        if(strs.length==1)return strs[0];
        String fir = strs[0];
        int firLen = fir.length();
        String prefix ;
        int i = 0;
        for(;i<firLen + 1;i++){
            prefix = fir.substring(0,i);
            boolean on = true;
            for(int j = 1 ; j<strs.length;j++){
                if(!strs[j].startsWith(prefix)){
                    on = false;
                    break;
                }
            }
            if(!on){
                break;
            }
        }
        i--;
        return fir.substring(0,i);
    }

    public static void main(String[] args){
        String a = "w";
        System.out.println(a.substring(0,0));
    }
}
