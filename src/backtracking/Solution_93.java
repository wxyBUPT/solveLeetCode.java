package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given a string containing only digits,
 restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution_93 {
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<>();
        helper(4,s,0,"",res);
        return res;
    }

    private void helper(int depth,String s,int start,String curr,List<String> res){
        if(depth==0&&start==s.length()){
            res.add(curr.substring(1));
            return;
        }
        if(depth<0)return;
        for(int i = 0;i<3;i++){
            if(start+i+1<=s.length()){
                String nextCurr = s.substring(start,start+i+1);
                if(!isLegal(nextCurr))return;
                if(nextCurr.length()>1&&nextCurr.startsWith("0"))return;
                helper(depth-1,s,start+i+1,curr+"." + nextCurr,res);
            }
        }
    }

    private boolean isLegal(String s){
        Integer res = Integer.parseInt(s);
        if(0<=res && res <=255)return true;
        else return false;
    }

    public static void main(String[] args){
        Solution_93 solution_93 = new Solution_93();
        String ques = "25525511135";
        List<String> res = solution_93.restoreIpAddresses(ques);
        System.out.println(res);
    }
}
