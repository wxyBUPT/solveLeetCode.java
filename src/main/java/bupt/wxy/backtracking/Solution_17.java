package bupt.wxy.backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/4/16.
 Given a digit main.java.bupt.wxy.string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit main.java.bupt.wxy.string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution_17 {
    private static Map<String,String> diMap = new HashMap<>(8);
    static {
        diMap.put("2","abc");
        diMap.put("3","def");
        diMap.put("4","ghi");
        diMap.put("5","jkl");
        diMap.put("6","mno");
        diMap.put("7","pqrs");
        diMap.put("8","tuv");
        diMap.put("9","wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()!=0) {
            helper(digits, res, "");
        }
        return res;
    }

    private void helper(String digiths,List<String> res,String tmp){
        if(digiths.length()==0){
            res.add(tmp);
            return;
        }
        String c = digiths.substring(0,1);
        String cString = diMap.get(c);
        for(int i = 0;i<cString.length();i++){
            helper(digiths.substring(1),res,tmp + cString.charAt(i));
        }
    }

    public static void main(String[] args){
        Solution_17 solution_17 = new Solution_17();
        String ques = "23";
        List<String> res = solution_17.letterCombinations(ques);
        System.out.println(res);
    }
}
