package bupt.wxy.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 10/22/16.
 */
public class Solution_124 {


    int maxPath;
    public Solution_124(){
        maxPath = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        int max = mmaxPathSum(root);
        return Math.max(max,maxPath);
    }

    private int mmaxPathSum(TreeNode root){
        if(root == null)return 0;
        int left = mmaxPathSum(root.left);
        int right = mmaxPathSum(root.right);
        if(left>=0&&right>=0) {
            maxPath = Math.max(left + right + root.val, maxPath);
            return root.val + Math.max(left, right);
        }
        else if(left<0&&right>=0){
            maxPath = Math.max(right+root.val,maxPath);
            return root.val + right;
        }else if(right<0&&left>=0){
            maxPath = Math.max(left + root.val,maxPath);
            return root.val + left;
        }else {
            maxPath = Math.max(root.val,maxPath);
            return root.val;
        }
    }
}
