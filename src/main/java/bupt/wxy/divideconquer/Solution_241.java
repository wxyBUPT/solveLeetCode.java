package bupt.wxy.divideconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 11/22/16.
 Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]
 */
public class Solution_241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+'||c=='*'||c=='-'){
                String s1 = input.substring(0,i);
                String s2 = input.substring(i+1,input.length());
                List<Integer> part1 = diffWaysToCompute(s1);
                List<Integer> part2 = diffWaysToCompute(s2);
                for(Integer p1:part1){
                    for(Integer p2:part2){
                        int c_res = 0;
                        switch (c){
                            case '-':
                                c_res = p1-p2;
                                break;
                            case '+':
                                c_res = p1 + p2;
                                break;
                            case '*':
                                c_res = p1 * p2;
                                break;
                        }
                        res.add(c_res);
                    }
                }
            }
        }
        if(res.size()==0)res.add(Integer.parseInt(input));
        return res;
    }
}
