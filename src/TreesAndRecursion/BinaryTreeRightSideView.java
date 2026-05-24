package TreesAndRecursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            //we only need to add the last element of the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.pollFirst();
                if (i == size - 1) {
                    ans.add(curr.val);
                }
                //add the left and right child
                if (curr.left != null) {
                    dq.addLast(curr.left);
                }
                if (curr.right != null) {
                    dq.addLast(curr.right);
                }
            }
        }
        return ans;
    }
}
