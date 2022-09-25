/**
 * 0104: Pre-Order Traversal with C++ stack and vector lists
 * Iterative procedure.
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
    // Pre-order is root -> left -> right
    vector<int> preorderTraversal(TreeNode* root) {
        // v stores the resulsts
        vector<int> v;
        
        // s stores nodes
        vector<TreeNode*> s;
        
        // root eventually moves down levels
        while (root != NULL || !s.empty()) {
            while (root != NULL) {
                
                // Push the root val into the stack first (v and s)
                v.push_back(root -> val);
                s.push_back(root);
                
                // traverse to the left
                root = root -> left;
            }
            
            // If there isn't a left child, look at the right child instead
            root = s.back() -> right;
            
            // Take out the already-processed node to eventually indicate termination
            s.pop_back();
        }
        return v;
    }
};
