// Updated 09.24.2022
// In-Order Traversal with Stack

/**
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


/* Recursive Solution
class Solution {
    List<Integer> res = new LinkedList<>(); // all the results are in a linked list
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root); // start from the root
        return res;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return; // keep recursing until reached the bottom
        inorder(root.left); // when this returns, time to move on
        res.add(root.val); // Report the root val, then move on to recurse in the right half
        inorder(root.right); // keep going down with the right halves
    }
}
*/
