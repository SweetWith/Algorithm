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

int arr[10000];
int idx = 0;
void search(TreeNode* head){
    if (head == nullptr) {
        return;
    }
    arr[idx++] = head->val;
    search(head->left);
    search(head->right);
}

class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        idx = 0;
        search(root);
        sort(arr, arr+idx);
        int min = 100000;
        int tmp;
        for (int i = 0; i < idx - 1; ++i) {
            tmp = arr[i+1] - arr[i];
            if (min > tmp)
                min = tmp;
        }
        return min;
    }
};
