/**
 * Recursive implementation of the ZigZag Tree Traversal with C++ vector lists.
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 
 Example: [3,9,20,null,null,15,7],

    3         lv = 1 (odd -> L to R)
   / \  
  9  20       lv = 2 (even -> R to L -> push elements from the back of queue)
    /  \ 
   15   7     lv = 3 (odd -> L to R -> push elements from the front of queue)
   
 Returns:

[
  [3],
  [20,9],
  [15,7]
]
 */

class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        auto ret = vector<vector<int>>();
        // Recursive call starts on the root
        zigzagLevelOrder(root, 0, ret);
        return ret;
    }
    
private:
    void zigzagLevelOrder(const TreeNode* root, int level, vector<vector<int>>& ret) {
        // Base case
        if (root == nullptr || level < 0) return;
        
        // Add levels if needed
        if (ret.size() <= level) {
            ret.push_back(vector<int>());
        }
        
        // If even level, push value from the back because 
        if (level % 2 == 0) ret[level].push_back(root->val);
        
        // If odd, push to the front
        else ret[level].insert(ret[level].begin(), root->val);
        
        // Recursion with level ++
        zigzagLevelOrder(root->left, level + 1, ret);
        zigzagLevelOrder(root->right, level + 1, ret);
    }
};
