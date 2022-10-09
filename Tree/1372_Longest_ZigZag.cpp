/**
 * 1372. Longest Zig Zag Path
 * Two cases: either from the L to R or from R to L
 * After each success addition, add 1 to the ZZ length
 * Otherwise, reset ZZ length to 0 hopefully to start the next one
 * 1 + (from == R ? len : 0); This decides whether to preserve the length
 * or re-start
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
 * Recursive return [left, right, result], where:
 * left is the maximum length in direction of root.left
 * right is the maximum length in direction of root.right
 * result is the maximum length in the whole sub tree.
*/

class Solution {
    public:
    int longestZigZag(TreeNode* root, int max = 0) {
        // Return the third return value of the call, "result"
        go(max, root);
        return max;
    }
    
    private:
        // Initival values of L and R are arbitrary
        int L = 0xABC, R = 0xDEF;
        
        void go(int& max, TreeNode* root, int from = 0, int len = 0) {
            if (!root) return;
            // Update the max if needed
            max = std::max(max, len);
            
            // The go() function recursively carries the current max value
            // And either goes from L to R or R to L
            // Max is the global max, len is the current path's len.
            go(max, root -> left, L, 1 + (from == R ? len : 0));
            go(max, root -> right, R, 1 + (from == L ? len : 0));
        }
    };
