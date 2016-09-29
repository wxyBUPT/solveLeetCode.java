package bupt.wxy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary main.java.bupt.wxy.tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary main.java.bupt.wxy.tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * 依旧使用栈,出栈的时候访问并访问右子树
 */
public class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        if(root==null)return result;
        TreeNode currentNode = root;
        while(currentNode != null){
            nodeStack.push(currentNode);
            currentNode = currentNode.left;
        }
        while(!nodeStack.isEmpty()){
            currentNode = nodeStack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
            while (currentNode!=null){
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
        }
        return result;
    }
}
