package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 *
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        boolean nodeSame = p.val == q.val;
        boolean leftSame = isSameTree(p.left,q.left);
        boolean rightSame = isSameTree(p.right,q.right);
        return nodeSame && leftSame && rightSame;
    }
}
