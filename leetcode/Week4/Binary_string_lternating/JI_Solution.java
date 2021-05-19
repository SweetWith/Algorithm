package leetcode.Week4.Binary_string_lternating;

public class JI_Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    int dfs(TreeNode root, int targetSum){
        if(root == null)
            return 0;
        return (root.val == targetSum ? 1 : 0) + dfs(root.left, targetSum-root.val) + dfs(root.right, targetSum - root.val);
    }
}
