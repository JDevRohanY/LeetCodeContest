package TreesAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //we want to do this by Morris traversal
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            //check if left is null
            if(curr.left == null){
                //if left is null
                //print left
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                //find the predecessor
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    //make the link from right to curr
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
