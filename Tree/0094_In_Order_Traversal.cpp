// 0094. A classic recursive implementation of in-order traversal.
class Solution {
public:
    
    void helper(TreeNode* root,vector &ans){
        if(root==NULL)return ;
      
        // L -> Root -> R
        helper(root->left,ans);
        ans.push_back(root->val);
        helper(root->right,ans);
        
    }
    vector inorderTraversal(TreeNode* root) {
      
        // Use a vector to store.
        vector ans;
        helper(root,ans);
        return ans;
    }
};
