package tree;

/**
 * Created by xiyuanbupt on 9/13/16.
 Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 */
public class Solution_226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
