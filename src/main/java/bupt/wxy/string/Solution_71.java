package bupt.wxy.string;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 10/20/16.
 */
public class Solution_71 {
    public String simplifyPath(String path) {
        String[] args = path.split("/");
        Stack<String> paths = new Stack<>();
        for(String arg:args){
            switch (arg){
                case ".":
                case "":
                    break;
                case "..":
                    if(paths.size()==0)paths.push("..");
                    else if(paths.peek().equals(".."))paths.push("..");
                    else paths.pop();
                    break;
                default:
                    paths.push(arg);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(paths.isEmpty())return "/";
        while (!paths.isEmpty()){
            String s = paths.remove(0);
            System.out.println(s);
            sb.append("/" + s);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution_71 sl = new Solution_71();
        String ans = sl.simplifyPath("/home/../a");
        System.out.println(ans);
    }
}
