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
vector<int> ans;

void search(TreeNode* head){
    if (head == nullptr) {
        return;
    }
    search(head->left);
    search(head->right);
    ans.push_back(head->val);
}

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        ans.clear();
        search(root);
        return ans;        
    }
};
