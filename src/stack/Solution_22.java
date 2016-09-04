package stack;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/3/16.
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */

/**
 * 使用栈
 */
public class Solution_22 {

    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n==0)return res;
        Stack<Integer> resStack = new Stack<>();
        int depth = n * 2;
        resStack.push(1);
        generateParenthesis(resStack,depth-1);
        return res;
    }

    private void generateParenthesis(Stack<Integer> resStack,int depth){
        if(depth==0){
            StringBuilder sb = new StringBuilder();
            int pri = 0;
            for(Integer i : resStack){
                if(i>pri) {
                    sb.append('(');
                }else {
                    sb.append(')');
                }
                pri = i;
            }
            res.add(sb.toString());
        }
        depth --;
        /**
         * 处理左括号
         */
        int next = resStack.peek()+1;
        if(next<=depth) {
            resStack.push(next);
            generateParenthesis(resStack, depth);
        }

        /**
         * 处理右括号
         */
        next = resStack.peek()-1;
        if(next>=0){
            resStack.push(next);
            generateParenthesis(resStack,depth);
        }

        /**
         * 因为传的是引用,所以不管怎么样最后一个元素都要被pop 出来
         */
        resStack.pop();
    }

    public static void main(String[] args){
        Solution_22 solution_22 = new Solution_22();
        List<String> res = solution_22.generateParenthesis(3);
        System.out.println(res);
    }
}
