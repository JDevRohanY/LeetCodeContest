package TreesAndRecursion;

public class BalancedBinaryTree {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        findBalanced(root);
        return isBalanced;
    }

    private int findBalanced(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findBalanced(root.left);
        if(left == -1) return -1;
        int right = findBalanced(root.right);
        if(right == -1) return -1;

        if(Math.abs(right-left)>1){
            isBalanced = false;
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
