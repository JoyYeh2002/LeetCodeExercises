/**
 * 0098. Validating a BST
 * Using in-order traversal (L -> Root -> R) and check if the result is sorted
 * If so, this IS a BST
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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode prev = null;
        
        while (root != null || !stack.isEmpty()) {
            // Achieve the L -> Root -> R order with a STACK
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            // It's not allowed to have a root that's less than the left child
            // Or a right child cannot be less than the root
            // prev can either be the L or the root
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            
            // Move on to the root
            prev = root;
            root = root.right;
        }
        
        // If is survives the while loop, the BST is validated.
        return true;
        
    }
}
