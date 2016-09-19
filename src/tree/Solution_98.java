package tree;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,(long)Integer.MIN_VALUE -1 ,(long)Integer.MAX_VALUE + 1);
    }

    /**
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isValidBST(TreeNode root,long min,long max){
        if(root == null)return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        boolean left ;
        boolean right ;
        left = isValidBST(root.left,min,root.val);
        right = isValidBST(root.right,root.val,max);
        return left && right;
    }

    public static void main(String[] args){
        Solution_98 sl = new Solution_98();
        TreeNode root = new TreeNode(2147483647);
        System.out.println(sl.isValidBST(root));
    }

}
