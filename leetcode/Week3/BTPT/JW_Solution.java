package leetcode.Week3.BTPT;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class JW_Solution {
    List<Integer> ans = new ArrayList<Integer>();
    public static void main(String[] args) {
    }
    public List<Integer> postorderTraversal(TreeNode root) {   
        postorder(root);
        return ans;
    }

    public void postorder(TreeNode root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        ans.add(root.val);
    }
}