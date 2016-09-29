package bupt.wxy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || (root.left == null && root.right == null))return root;
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root,p,pPath);
        findPath(root,q,qPath);
        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)){
            System.out.println(pPath.get(i));
            System.out.println(qPath.get(i));
            i++;
        }
        return pPath.get(i-1);
    }

    private boolean findPath(TreeNode root,TreeNode p,List<TreeNode> path){
        if(root == null)return false;
        path.add(root);
        if(root==p){
            return true;
        }

        boolean left = findPath(root.left,p,path);
        if(left)return true;
        boolean right = findPath(root.right,p,path);
        if(right)return true;
        path.remove(path.size() -1);
        return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode p = new TreeNode(3);
        root.left = q;root.right = p;
        Solution_236 sl = new Solution_236();
        TreeNode cm = sl.lowestCommonAncestor(root,q,p);
        System.out.println(cm.val);
    }
}
