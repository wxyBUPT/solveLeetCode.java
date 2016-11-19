package bupt.wxy.string;

import java.util.*;

/**
 * Created by xiyuanbupt on 11/19/16.
 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Solution_459 {

    public boolean repeatedSubstringPattern(String str) {

        int len = str.length();
        char[] c_str = str.toCharArray();

        List<Integer> dividers = getDividers(len);
        if(dividers.size()==0)return false;

        for(int divide:dividers){
            if(repeated(c_str,divide,len/divide)){
                return true;
            }
        }
        return false;
    }

    boolean repeated(char[] str, int memCount, int groupCount){

        System.out.println("memCount: " + memCount + ", groupCount: " + groupCount);
        int[] groupIndex = new int[groupCount];
        for(int i=0;i<groupCount;i++){
            groupIndex[i] = i*memCount;
        }
        for(int i = 0;i<memCount;i++){
            char curr = str[groupIndex[0]++];
            for(int j = 1;j<groupCount;j++){
                if(str[groupIndex[j]++] != curr)return false;
            }
        }
        return true;
    }

    List<Integer> getDividers(int a) {

        List<Integer> res = new ArrayList<>();

        double mid = a/2;
        for (int i = 1; i <= mid; i++) {
            if (a % i == 0) {
                res.add(i);
            }
        }
        Collections.reverse(res);

        // 有共同公倍数的不要重复处理
        Set<Integer> handles = new HashSet();
        for(int i:res){
            boolean handled = false;
            for(int j:handles){
                if(j%i==0&&j/i>1){
                    handled = true;
                }
            }
            if(!handled)handles.add(i);
        }
        return new ArrayList<>(handles);
    }

    public static void main(String[] args){
        Solution_459 sl = new Solution_459();
        boolean res = sl.repeatedSubstringPattern("bb");
        System.out.println(res);
    }
}
