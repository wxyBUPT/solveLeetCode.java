package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 11/20/16.
 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class Solution_395 {

    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int len = str.length;
        return helper(str, 0, len ,k);
    }

    int helper(char[] str, int start, int end, int k){
        if(end<=start)return 0;
        if(end-start<k)return 0;
        int[] dict = new int[26];
        for(int i = start;i<end;i++){
            dict[str[i] - 'a']++;
        }

        for(int i =0;i<26;i++){
            if(dict[i] == 0)continue;
            if(dict[i]<k){
                for(int j = start;j<end;j++){
                    if(str[j] == (char) i+ 'a'){
                        int left = helper(str,start,j,k);
                        int right = helper(str, j+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end - start;

    }
}
