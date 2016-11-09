package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 11/9/16.
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.
 */
public class Solution_129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    int dfs(TreeNode root,int curr){
        if(root==null)return 0;
        int m_curr = curr * 10 + root.val;
        if(root.left == null && root.right == null){
            return m_curr;
        }
        else {
            return dfs(root.left,m_curr) + dfs(root.right,m_curr);
        }
    }
}
