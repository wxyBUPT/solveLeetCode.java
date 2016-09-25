package main.java.bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary main.java.bupt.wxy.tree and a sum,
 determine if the main.java.bupt.wxy.tree has a root-to-leaf path such that
 adding up all the values along the path equals the given sum.

 For example:
 Given the below binary main.java.bupt.wxy.tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is
 22
 */
public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)return false;
        return hasPath(root,sum);

    }

    public boolean hasPath(TreeNode root,int sum){
        if(root.left==null&&root.right==null){
            if(root.val == sum)return true;
            else return false;
        }
        if(root.left!=null){
            if(hasPath(root.left,sum-root.val))return true;
        }
        if(root.right!=null)return hasPath(root.right,sum-root.val);
        return false;
    }

}
