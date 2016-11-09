package bupt.wxy.hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 11/9/16.
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Solution_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] needs = new int[26];
        for(Character c:p.toCharArray()){
            needs[c-'a']++;
        }

        int j = p.length();
        int i = 0;
        if(s.length()<j)return res;
        for(int k = i;k<j;k++){
            needs[s.charAt(k)-'a']--;
        }
        if(valid(needs))res.add(i);
        while (j<s.length()){
            needs[s.charAt(i++)-'a']++;
            needs[s.charAt(j++)-'a']--;
            if(valid(needs))res.add(i);
        }
        if(valid(needs))res.add(i);
        return res;
    }

    boolean valid(int[] needs){
        for(int i = 0;i<26;i++)
            if(needs[i]!=0){
                return false;
            }
        return true;
    }

    public static void main(String[] args){
        Solution_438 sl = new Solution_438();
        List<Integer> res = sl.findAnagrams("baa","aa");
        System.out.println(Arrays.toString(res.toArray()));

    }
}
