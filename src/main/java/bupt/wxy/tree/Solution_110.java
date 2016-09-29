package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary main.java.bupt.wxy.tree, determine if it is height-balanced.

 For this problem, a height-balanced binary main.java.bupt.wxy.tree is defined
 as a binary main.java.bupt.wxy.tree in which the depth
 of the two subtrees of every node never differ by more than 1.
 */
public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        boolean leftBalance = isBalanced(root.left);
        boolean rightBalance = isBalanced(root.right);
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.abs(leftDepth-rightDepth)<2 && leftBalance && rightBalance;
    }

    private int getDepth(TreeNode root){
        if(root==null)return 0;
        int leftDepth = 1 + getDepth(root.left);
        int rightDepth = 1 + getDepth(root.right);
        return Math.max(leftDepth,rightDepth);
    }

}
