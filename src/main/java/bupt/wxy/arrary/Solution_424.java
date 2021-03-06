package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 11/19/16.
 Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

 Note:
 Both the string's length and k will not exceed 104.

 Example 1:

 Input:
 s = "ABAB", k = 2

 Output:
 4

 Explanation:
 Replace the two 'A's with two 'B's or vice versa.
 Example 2:

 Input:
 s = "AABABBA", k = 1

 Output:
 4

 Explanation:
 Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class Solution_424 {

    public int characterReplacement(String s, int k) {

        char[] c_s = s.toCharArray();
        int max = 0;
        for(int i = 0;i<26;i++){
            char c = (char)('A' + i);
            max = Math.max(helper(c_s,k,c),max);
        }
        return max;
    }

    int helper(char[] s, int k, char c){
        int len = s.length;
        int remain = k;
        int i = 0;
        int j = 0;
        int max = 0;
        while (j<len){
            while (remain>0){
                while (j<len &&s[j]==c){
                    j++;
                }
                remain--;
                j++;
            }
            while (j<len && s[j]==c){
                j++;
            }
            j = Math.min(j,len);
            max = Math.max(j-i,max);
            while (i<len && s[i]==c && i<j){
                i++;
            }
            i++;
            remain++;
        }
        return max;
    }

    public static void main(String[] args){
        Solution_424 sl = new Solution_424();
        int res = sl.characterReplacement("ABAA",0);
        System.out.println(res);
    }
}
