/**
 * 0936. Range Sum of BST
 * Sum of all nodes of a tree which values are in the inclusive range of [low, high]
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 *
 * Use param expansion to keep passing in low and high
 * [?] Why do we seem to recurse with count() twice?
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
class Solution {
    int c = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        count(root.left, low, high);
        count(root.right, low, high);
        // (condition) ? instruction if yes : instruction if no
        return (root.val >= low && root.val <= high) ? c + root.val: c;
    }
    
    public void count(TreeNode root, int L, int H) {
        if (root == null) return;
        // This works
        if (root.val >= L && root.val <= H) c += root.val;
        
        // Keep looking if it only satisfy the "OR", not the "AND"
        if (root.val <= L || root.val < H) count(root.right, L, H);
        if (root.val >= H || root.val > L) count(root.left, L, H);
    }
}
