package tree;

/**
 * Created by xiyuanbupt on 8/31/16.
 */
public class Solution_104 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

