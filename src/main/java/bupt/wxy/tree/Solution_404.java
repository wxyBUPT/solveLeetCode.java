package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 10/28/16.
 Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
 /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,false);
    }

    int sumOfLeftLeaves(TreeNode root,boolean isleft){
        if(root == null)return 0;
        if(root.right==null&&root.left==null&&isleft)return root.val;
        return sumOfLeftLeaves(root.left,true) + sumOfLeftLeaves(root.right,false);
    }
}
