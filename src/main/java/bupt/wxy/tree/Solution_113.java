package main.java.bupt.wxy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary main.java.bupt.wxy.tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary main.java.bupt.wxy.tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

/**
 * 使用stack
 */
public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        DFS(root,new ArrayList<Integer>(),sum,0,res);
        return res;
    }

    private void DFS(TreeNode root,List<Integer> path,int sum,int currSum,List<List<Integer>> res){
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(currSum == sum){
                res.add(new ArrayList<>(path));
            }
        }else {
            if(root.left!=null)DFS(root.left,path,sum,currSum,res);
            if(root.right!=null)DFS(root.right,path,sum,currSum,res);
        }
        path.remove(path.size()-1);
    }

}
