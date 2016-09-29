package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 9/13/16.

 Given a binary search main.java.bupt.wxy.tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia:
 “The lowest common ancestor is defined
 between two nodes v and w as the lowest node in T
 that has both v and w as descendants
 (where we allow a node to be a descendant of itself).”

 _______6______
 /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
 /  \
 3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 Another example is LCA of nodes 2 and 4 is 2,
 since a node can be a descendant of itself according to the LCA definition.
 */

public class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int p_val = p.val;
        int q_val = q.val;
        while ((root.val<=p_val&& root.val<=q_val) || (root.val>=q_val&&root.val>=p_val)){
            if(root.val==p_val||root.val==q_val)return root;
            if(root.val<=p_val)root = root.right;
            else root = root.left;
        }
        return root;
    }
}
