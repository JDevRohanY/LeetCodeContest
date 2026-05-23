package TreesAndRecursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            //check the curr size of queue
            int size = dq.size();
            for(int i=0; i<size; i++){
                TreeNode curr = dq.pollFirst();
                currLevel.add(curr.val);
                if(curr.left!=null){
                    dq.addLast(curr.left);
                }
                if(curr.right!=null){
                    dq.addLast(curr.right);
                }
            }
            ans.add(currLevel);
        }
        return ans;
    }
}
