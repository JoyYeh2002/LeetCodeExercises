/**
 * Iterative implementation of post-order traversal of a tree
 * Using a stack to visit children first, then the root
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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> v;
        stack<TreeNode*> s;
        TreeNode *prev = NULL;
        
        while (root || s.size()) {
            
            // Keep pushing roots into the stack because they're accessed last
            while (root) {
                s.push(root);
                
                // Go down to the left
                root = root -> left;
            }
            
            // The current root is the newset root on the stack
            root = s.top();
            
            // If the root doesn't have a right child or right == prev (already visited)
            if (!root -> right || root -> right == prev) {
                // Time to record into the output because reached the end of tree
                v.push_back(root -> val);
                // Take this element out of the stack
                s.pop();
                prev = root;
                root = NULL;
            } else root = root -> right;
        }
        return v;
    }
};
