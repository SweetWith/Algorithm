package leetcode.Week3.BTPT;

import java.util.ArrayList;
import java.util.List;

public class JI_Solution {
    List<Integer> ret;
    public List<Integer> postorderTraversal(TreeNode root) {
        ret = new ArrayList<>();
        solve(root);
        return ret;
    }
    public void solve(TreeNode root){
        if(root == null)
            return ;

        solve(root.left);
        solve(root.right);
        ret.add(root.val);
    }
}
