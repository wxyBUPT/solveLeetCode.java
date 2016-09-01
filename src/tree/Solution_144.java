package tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归方式前序遍历,印象中好难
 * 利用栈,进栈访问左边,出栈访问右边
 */
public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currNode = root;
        while (currNode!=null){
            nodeStack.add(currNode);
            res.add(currNode.val);
            currNode = currNode.left;
        }
        while(!nodeStack.isEmpty()){
            currNode = nodeStack.pop().right;
            while(currNode!=null){
                nodeStack.add(currNode);
                res.add(currNode.val);
                currNode = currNode.left;
            }
        }
        return res;
    }
}
