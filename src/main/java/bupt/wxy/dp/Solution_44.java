package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/29/16.
 */
public class Solution_44 {

    public boolean isMatch(String s, String p) {
        if(s.length()==0&&p.length()==0)return true;
        return isMatch(s,0,s.length() - 1,p,0,p.length() - 1);
    }

    private boolean isMatch(String s,int s_s,int s_e,String p ,int p_s,int p_e){

        System.out.println("s: " + s.substring(s_s,s_e + 1));
        System.out.println("p: " + p.substring(p_s,p_e + 1));
        if(s_s > s_e && p_s > p_e){
            return true;
        }
        while ( s_s <= s_e && p_s <= p_e && (s.charAt(s_s) == p.charAt(p_s) || p.charAt(p_s) == '?')){
            s_s ++;
            p_s++;
        }
        while (s_s<=s_e && p_s <= p_e && (s.charAt(s_e) == p.charAt(p_e)||p.charAt(p_e) =='?') ){
            s_e--;
            p_e --;
        }

        boolean s_cousumed = s_s > s_e;
        boolean p_consumed = p_s > p_e;
        if(s_cousumed ^ p_consumed){
            if(p_consumed) {
                return false;
            }else {
                while (p_s<=p_e){
                    if(p.charAt(p_s)!='*')return false;
                    p_s ++;
                }
                return true;
            }
        }
        if(s_cousumed)return true;
        //执行上面的代码已经保证p 的两端遇到 * 了
        if(p.charAt(p_s) != '*' || p.charAt(p_e)!='*'){
            return false;
        }
        //从p 的前面开始处理掉 *
        while (p_s <= p_e&& p.charAt(p_s)=='*')p_s++;
        //计算s 至少需要多少个字母才能满足
        int minCount = 0;
        for(int i = p_s;i<=p_e;i++){
            if(p.charAt(i)!='*')minCount ++;
        }
        for(int i = s_e + 1;i>=s_s;i--){
            if(s_e - i + 1 == minCount) {
                if (isMatch(s, i, s_e, p, p_s, p_e)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Solution_44 sl = new Solution_44();
        boolean ans = sl.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb");
        System.out.println(ans);
    }
}
