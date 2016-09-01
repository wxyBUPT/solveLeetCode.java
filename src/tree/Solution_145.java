package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */

/**
 * 二叉树的后续遍历,非递归
 * 同样是使用栈
 * 但是使用双栈
 */
public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Boolean> visitStack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode != null){
            nodeStack.push(currentNode);
            visitStack.push(false);
            currentNode = currentNode.left;
        }

        while (!nodeStack.isEmpty()){
            if(visitStack.peek()==true){
                visitStack.pop();
                currentNode = nodeStack.pop();
                result.add(currentNode.val);
                if(!visitStack.isEmpty()) {
                    if(nodeStack.peek().right == currentNode) {
                        visitStack.pop();
                        visitStack.push(true);
                    }
                }
            }else {
                currentNode = nodeStack.peek().right;
                if(currentNode==null){
                    if(!visitStack.isEmpty()) {
                        visitStack.pop();
                        visitStack.push(true);
                    }
                }
                while (currentNode!=null){
                    visitStack.push(false);
                    nodeStack.push(currentNode);
                    currentNode = currentNode.left;
                }
            }
        }
        return result;
    }
}
