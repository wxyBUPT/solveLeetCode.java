package main.java.bupt.wxy.arrary;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/5/16.
 */
public class Solution_245 {


    static Set<Character> vows = new HashSet();
    static {
        vows.add('a');
        vows.add('e');
        vows.add('i');
        vows.add('o');
        vows.add('u');
        vows.add('A');
        vows.add('E');
        vows.add('I');
        vows.add('O');
        vows.add('U');
    }

    public String reverseVowels(String s) {

        List<Integer> vowPos = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(vows.contains(s.charAt(i))){
                vowPos.add(i);
            }
        }
        StringBuilder sb = new StringBuilder(s);

        int len = vowPos.size();
        int mid = len/2;
        int j ;
        for(int i = 0;i<mid;i++){
            j = len - i -1;
            Character tmp = sb.charAt(vowPos.get(i));
            sb.setCharAt(vowPos.get(i),sb.charAt(vowPos.get(j)));
            sb.setCharAt(vowPos.get(j),tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution_245 solution_245 = new Solution_245();
        String res = solution_245.reverseVowels("leetcode");
        System.out.println(res);
    }
}
