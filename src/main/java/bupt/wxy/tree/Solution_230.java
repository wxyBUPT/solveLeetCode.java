package bupt.wxy.tree;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 10/4/16.
 */
public class Solution_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int n = 0;
        while (curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            n ++;
            if(n==k)return tmp.val;
            curr = tmp.right;
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        return -1;
    }
}
