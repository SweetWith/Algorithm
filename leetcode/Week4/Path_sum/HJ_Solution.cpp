/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
int DP[1005];
int ans;
int target;
void solve(TreeNode* head, int r) {
    TreeNode* lo = head->left;
    TreeNode* ro = head->right;
    int val = head->val;
    DP[r] = DP[r - 1] + val;
    int to = r;
    while (to >= 1) {
        if (DP[r] - DP[to -1] == target) {
            ans++;
        }
        --to;
    }
    if (lo != nullptr) {
        solve(lo, r + 1);    
    }
    if (ro != nullptr) {
        solve(ro, r + 1);
    }
}
class Solution {
public:
    int pathSum(TreeNode* root, int targetSum) {
        ans = 0;
        target = targetSum;
        if (root != nullptr) {
            solve(root, 1);
        }
        return ans;
    }
};
