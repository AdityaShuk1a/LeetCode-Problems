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
class Solution {
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        // int temp = root->left->val;
        // root->left->val = root->right->val;
        // root->right->val = temp;
        reverseF(root->left, root->right, 0);
        return root;


    }
    void reverseF(TreeNode* leftC, TreeNode* rightC, int level){
        if(leftC == NULL || rightC == NULL){
            return;
        }

        if(level%2==0){
            int temp = leftC->val;
            leftC->val = rightC->val;
            rightC->val = temp;
        }
        reverseF(leftC->left, rightC->right, level+1);
        reverseF(leftC->right, rightC->left, level+1);

    }
    
};