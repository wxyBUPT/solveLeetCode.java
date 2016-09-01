package tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */

import java.util.Stack;

/**
 * 有点类似于节点旋转
 */
public class Solution_114 {
    public void flatten(TreeNode root) {
        if(root == null)return ;
        flattenn(root);
    }

    public TreeNode flattenn(TreeNode root){
        if(root==null)return null;
        if(root.left==null&&root.right==null){
            return root;
        }
        else if(root.left!=null&&root.right!=null) {
            TreeNode leftStart = root.left;
            TreeNode leftEnd = flattenn(root.left);
            TreeNode rightStart = root.right;
            TreeNode rightEnd = flattenn(root.right);
            root.right = leftStart;
            leftEnd.right = rightStart;
            root.left = null;
            return rightEnd;
        }else if(root.left!=null&&root.right==null){
            TreeNode leftStart =root.left;
            TreeNode leftEnd = flattenn(root.left);
            root.right = leftStart;
            root.left = null;
            return leftEnd;
        }else {
            TreeNode rightEnd = flattenn(root.right);
            return rightEnd;
        }
    }
}
