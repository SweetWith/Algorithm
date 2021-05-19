package leetcode.Week3.BST;

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
    int min; // 최소값
    int prev; // 이전값
    boolean flag = false; // prev 유무
    public static void main(String[] args) {
        JW_Solution jw = new JW_Solution();
        TreeNode root = new TreeNode();
        System.out.println(jw.getMinimumDifference(root));
    }
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(!flag) {
            flag = true;
        } else {
            int temp = Math.abs(prev - root.val);
            min = Math.min(temp, min);
        }
        prev = root.val;
        
        inorder(root.right);
    }
}
