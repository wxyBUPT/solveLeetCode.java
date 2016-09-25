package main.java.bupt.wxy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given a main.java.bupt.wxy.string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke",
 with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 用于记录出现当前char 的位置
         */
        Map<Character,Integer> charPos = new HashMap<>(128);
        /**
         * 确定一点
         */
        int maxCount = 0 ;
        for(int i = 0;i<s.length();i++){
            int j = i ;
            while (j<s.length()){
                Integer pos = charPos.get(s.charAt(j));
                if(pos != null){
                    int count  = charPos.keySet().size();
                    maxCount = maxCount>count?maxCount:count;
                    while(i<=pos){
                        charPos.remove(s.charAt(i));
                    }
                    break;
                }
                else {
                    charPos.put(s.charAt(j),j);
                    j++;
                    if(j==s.length()){
                        int count = charPos.keySet().size();
                        maxCount = maxCount>count?maxCount:count;
                    }
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args){

    }
}
