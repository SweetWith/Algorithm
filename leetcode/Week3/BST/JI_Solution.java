package leetcode.Week3.BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JI_Solution {
    public int getMinimumDifference(TreeNode root) {

        List<Integer> number = new ArrayList<>();
        return solve(root,number);
    }

    public int solve(TreeNode root, List<Integer> number) {
        int ret = 10000000;

        if (root == null) {
            Collections.sort(number);
            for (int i = 0; i < number.size() - 1; i++) {
                ret = Math.min(ret, number.get(i + 1) - number.get(i));
            }
            return ret;
        }

        number.add(root.val);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(number);
        return Math.min(solve(root.left, temp), solve(root.right, temp));
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
