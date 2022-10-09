/**
 * 0653. Two Sum IV - Input is a BST
 * Use a hash set to store the values: Set<Integer> set = new HashSet<>();
 * DFS with main logic in front of the recursion
 * Main logic: if something in the set can satifsy the summing
 * The set keeps getting more and more elements
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        // Expand the params: send the set as a param
        return dfs(root, set, k);
    }
    
    public static boolean dfs(TreeNode root, Set<Integer> set, int target) {
        // Base case
        if (root == null) {
            return false;
        }
        
        // Main logic: if the target condition is met
        // Here we can end early with boolean return
        if (set.contains(target - root.val)) {
            return true;
        }
        
        // We can only push in the roor first
        set.add(root.val);
        
        // Recursion
        return dfs(root.left, set, target) || dfs(root.right, set, target);
        
    }
    
}
