package bupt.wxy.tree;

import java.util.Stack;

/**
 * Created by xiyuanbupt on 9/13/16.
 Implement an iterator over a binary search main.java.bupt.wxy.tree (BST).
 Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h)
 memory, where h is the height of the main.java.bupt.wxy.tree.
 */
public class BSTIterator {

    private Stack<TreeNode> nodeStack;

    public BSTIterator(TreeNode root) {
        nodeStack = new Stack<>();
        while (root!=null){
            nodeStack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = nodeStack.pop();
        TreeNode tmp = node.right;
        while (tmp!=null){
            nodeStack.push(tmp);
            tmp = tmp.left;
        }
        return node.val;
    }
}
