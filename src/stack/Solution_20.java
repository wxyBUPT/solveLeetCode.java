package stack;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 9/3/16.
 Given a string containing just the characters '(', ')', '{', '}', '['
 and ']',
 determine if the input string is valid.

 The brackets must close in the correct order,
 "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution_20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('||c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            switch (c){
                case ']':
                    if(stack.size()==0)return false;
                    if(stack.pop()!='[')return false;
                    break;
                case '}':
                    if(stack.size()==0)return false;
                    if(stack.pop()!='{')return false;
                    break;
                case ')':
                    if(stack.size()==0)return false;
                    if(stack.pop()!='(')return false;
                    break;
                default:
                    break;
            }
        }
        if(stack.size()!=0)return false;
        return true;
    }
}
