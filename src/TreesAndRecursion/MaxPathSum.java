package TreesAndRecursion;

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    public int findMax(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,findMax(node.left));
        int right = Math.max(0,findMax(node.right));
        //either i can choose left and right max
        int temp = Math.max(left, right) + node.val;
        //either it will take the path from root itself
        maxSum = Math.max(maxSum, left + right + node.val);
        return temp;
    }
}
