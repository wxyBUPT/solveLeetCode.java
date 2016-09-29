package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 8/31/16.
 */
public class Solution_111 {

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root){
        if(root==null)return 0;
        travel(root,1);
        return minDepth;
    }

    private void travel(TreeNode root,int height){
        if(root==null)return;
        if(root.right==null&&root.left==null){
            minDepth = Math.min(minDepth,height);
            return;
        }
        travel(root.right,height+1);
        travel(root.left,height+1);
    }

    public static void main(String[] args){
        Solution_111 solution_111 = new Solution_111();
        TreeNode root = new TreeNode(0);

        int i = solution_111.minDepth(root);
        System.out.println(i);
    }

}
