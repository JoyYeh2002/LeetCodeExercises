/**
 0199. Binary Tree Right Side View
 Input: [1,2,3,null,5,null,4]
 Output: [1, 3, 4]
 Sample:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
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
    vector<int> rightSideView(TreeNode* root) {
        
        // V stores the results
        auto v = vector<int>();
        
        // Mark the termination condition
        if (root == nullptr) return v;
        
        // Create a queue (similar to that of level-order traversal)
        auto q = queue<const TreeNode*>();
        
        // Root is the first returned element, so it goes into the queue first
        // FIFO
        q.push(root);
        
        while (!q.empty()) {
            // [?] How do the sizes change?
            auto size = q.size();
            for (auto i = 0; i < size; i++) {
                // Examine the top element in queue
                auto n = q.front();
                q.pop();
                
                // Push in left child
                if (n -> left != nullptr) q.push(n -> left);
                
                // Push in right child
                if (n -> right != nullptr) q.push(n -> right);
                
                // When reached the last elem in this level, put the current element into the results list (this has to be a right child)
                // If we want the left-tree view instead, take the last element of the queue (FIFO)
                if (i == size - 1) v.push_back(n -> val);
            }
        }
        return v;
    }
};
