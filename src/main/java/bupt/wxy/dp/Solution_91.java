package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/22/16.
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class Solution_91 {
    public int numDecodings(String s) {
        if(s.length()==0)return 0;
        int[] dp = new int[s.length()];
        Character c0 = s.charAt(0);
        Character c1 = null;
        // 初始化dp0 dp1
        if(c0 == '0'){
            dp[0] = 0;
        }else {
            dp[0] = 1;
        }
        if(s.length()>=2){
            c1 = s.charAt(1);
            if(c1 =='0'){
                if(c0=='1' || c0 == '2')dp[1] = 1;
                else dp[1]=0;
            }else {
                if(c0=='0')dp[1] = 0;
                else if(c0=='1')dp[1] = 1 + 1;
                else if(c0=='2'){
                    if(c1<'7')dp[1] = 1 + 1;
                    else dp[1] = 1;
                }else {
                    dp[1] = 1;
                }
            }
            c0 = c1;
        }
        for(int i = 2;i<s.length();i++){
            c1 = s.charAt(i);

            if(c1=='0'){
                if( c0 == '2' || c0 =='1')dp[i] = dp[i-2];
                else dp[i]= 0;
            }
            else {
                if(c0=='0')dp[i] = dp[i-1];
                else if(c0=='1')dp[i] = dp[i-1] + dp[i-2];
                else if(c0=='2'){
                    if(c1<'7')dp[i] = dp[i-1] + dp[i-2];
                    else dp[i] = dp[i-1];
                }else {
                    dp[i] = dp[i-1];
                }
            }
            c0 = c1;
        }
        return dp[s.length()-1];

    }
}
