package TreesAndRecursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        boolean reverse = true;
        while(!dq.isEmpty()){
            reverse = !reverse;
            int size = dq.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = dq.pollFirst();
                if(reverse){
                    currLevel.add(0, curr.val);
                }else{
                    currLevel.add(curr.val);
                }
                //check the child
                if(curr.left != null){
                    dq.addLast(curr.left);
                }
                if(curr.right != null){
                    dq.addLast(curr.right);
                }
            }
            ans.add(currLevel);
        }
        return ans;
    }
}
