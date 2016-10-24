package bupt.wxy.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 10/24/16.
 Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Solution_394 {

    static Map<String,Integer> map ;
    static {
        map = new HashMap<>();
        for(int i = 0;i<9;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            map.put(sb.toString(),i);
        }
    }
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        StringBuilder pr = new StringBuilder();
        while (i<s.length()){
            String c = "" +s.charAt(i);
            if(map.containsKey(c)){
                stack.push(c);
            }
            else if("[".equals(c)){
                stack.push(c);
            }else if("]".equals(c)){
                String pre = pr.toString();

                System.out.println("一次");
            }else {
                pr.append(c);
            }
        }
        return "";
    }
    public static void main(String[] args){
        int a = 1;
        char b = (char)(a +'0');
        System.out.println(b);
    }
}
