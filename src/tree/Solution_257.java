package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 */

public class Solution_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        binaryTreePaths(root,res,new ArrayList<Integer>());
        return res;
    }

    private void binaryTreePaths(TreeNode curr,List<String> res,List<Integer> path){
        if(curr==null)return ;
        path.add(curr.val);
        if(curr.left==null && curr.right==null){
            StringBuilder sb = new StringBuilder();
            for(Integer i :path){
                sb.append(i);
                sb.append("->");
            }
            String tmp = sb.toString();
            tmp = tmp.substring(0,tmp.length()-2);
            res.add(tmp);
        }
        else {
            binaryTreePaths(curr.left, res, path);
            binaryTreePaths(curr.right, res, path);
        }
        path.remove(path.size()-1);
    }

}
