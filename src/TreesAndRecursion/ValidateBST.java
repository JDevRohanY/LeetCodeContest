package TreesAndRecursion;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;

        return isValid(root, left, right);
    }

    private boolean isValid(TreeNode node, long leftMax, long rightMax){
        if(node == null){
            return true;
        }
        if(node.val>leftMax && node.val<rightMax){
            //check for left child and right child
            return isValid(node.left, leftMax, node.val) && isValid(node.right, node.val, rightMax);
        }
        return false;
    }
}
