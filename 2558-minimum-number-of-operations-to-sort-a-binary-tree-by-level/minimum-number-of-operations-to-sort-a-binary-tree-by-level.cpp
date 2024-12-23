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
int Increasing(vector<int>arr){
    vector<int>temp=arr;
    sort(temp.begin(),temp.end());
    unordered_map<int,int>mp;
    for(int i=0;i<temp.size();i++)
    mp[temp[i]]=i;
    int op=0;
    for(int i=0;i<temp.size();i++){
        while(mp[arr[i]]!=mp[temp[i]])
        {
            swap(arr[mp[arr[i]]],arr[mp[temp[i]]]);
            op++;
        }
    }
    return op;
}

int Operation(vector<int>values){

    int Inc=Increasing(values);  
    return Inc;
}
    int minimumOperations(TreeNode* root) {
        queue<TreeNode*>q;
        q.push(root);
        vector<int>values;
        int ans=0;
        while(!q.empty()){
            int sz=q.size();
            vector<int>temp;
            for(int i=0;i<sz;i++){
                TreeNode*node=q.front();
                q.pop();

                temp.push_back(node->val);
                if(node->left)
                q.push(node->left);
                if(node->right)
                q.push(node->right);
            }
            values=temp;
            ans+=Operation(values);
        }
        return ans;
    }
};