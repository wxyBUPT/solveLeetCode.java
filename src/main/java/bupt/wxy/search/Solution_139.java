package bupt.wxy.search;

import java.util.*;

/**
 * Created by xiyuanbupt on 10/11/16.
 */
public class Solution_139 {

    public boolean wordBreak(String s,Set<String> dict){
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(f[j] && dict.contains(s.substring(j,i))){
                    f[i] = true;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        Set<String> wordDict = new HashSet<>();
        Collections.addAll(wordDict,"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        Solution_139 sl = new Solution_139();
        boolean ans = sl.wordBreak(s,wordDict);
        System.out.println(ans);
    }
}
