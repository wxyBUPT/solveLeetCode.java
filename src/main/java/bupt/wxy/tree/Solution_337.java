package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_337 {

    public int rob1(TreeNode root) {
        if(root==null)return 0;
        Node nodeRoot = buildTree(root);
        return Math.max(robRoot(nodeRoot),passRoot(nodeRoot));
    }

    private int robRoot(Node root){
        if(root == null)return 0;
        if(root.robRoot !=null)return root.robRoot;
        else {
            int rob = root.val + passRoot(root.left) + passRoot(root.right);
            root.robRoot = rob;
            return rob;
        }
    }

    private int passRoot(Node root){
        if(root == null)return 0;
        if(root.passRoot != null)return  root.passRoot;
        int robRootRight = robRoot(root.right);
        int robRootLeft = robRoot(root.left);
        int passRootRight = passRoot(root.right);
        int passRootLeft = passRoot(root.left);
        int pass = Math.max(
                robRootLeft + robRootRight,Math.max(
                        robRootLeft + passRootRight,Math.max(
                                robRootRight + passRootLeft,
                                passRootLeft + passRootRight
                        )
                )
        );

        root.passRoot = pass;
        return pass;
    }

    class Node {

        Integer robRoot;
        Integer passRoot;
        int val;
        Node left;
        Node right;


        public Node(int x){
            this.val = x;
        }
    }

    private Node buildTree(TreeNode root){
        if(root!=null){
            Node node = new Node(root.val);
            node.left = buildTree(root.left);
            node.right = buildTree(root.right);
            return node;
        }else {
            return null;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
