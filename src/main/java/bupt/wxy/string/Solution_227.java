package bupt.wxy.string;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_227 {

    static Map<Character,Integer> map = new HashMap<>();
    static Set<Character> op = new HashSet<>();
    static {
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        /**
        for(int i = 0;i<9;i++){
            map.put((char)i,i);
        }
         **/
        op.add('+');
        op.add('-');
        op.add('*');
        op.add('/');
    }

    public int calculate(String s) {
        s = s + "+";
        Stack<Integer> numStack = new Stack<>();
        numStack.push(0);
        char lop = '+';
        int curr = 0;
        int len = s.length();
        for(int i = 0;i<len;i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                curr = curr * 10 + map.get(c);
            }else if(op.contains(c)) {
                switch (lop) {
                    case '+':
                        numStack.push( curr);
                        curr = 0;
                        break;
                    case '-':
                        numStack.push( - curr);
                        curr = 0;
                        break;
                    case '*':
                        numStack.push(numStack.pop() * curr);
                        curr = 0;
                        break;
                    case '/':
                        numStack.push(numStack.pop() / curr);
                        curr = 0;
                        break;
                    default:
                        break;
                }
                lop = c;
            }
        }
        int re = 0;
        for(int i : numStack){
            re += i;
        }
        return re;
    }

    public static void main(String[] args){
    }

}
