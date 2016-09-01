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
 * 使用的思路是preOrder
 * 非递归方式
 */
public class Solution_114 {
    public void flatten(TreeNode root) {
        if(root == null)return ;
        Stack<TreeNode> nodeStack = new Stack<>();

    }
}
