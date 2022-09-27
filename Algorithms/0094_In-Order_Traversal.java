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

// Iterative solution
class Solution {
    // In-order traversal goes left, root, right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        // root doesn't get used until all the left children are checked. A stack (LIFO) is good for this task.
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root); // Get the root in there first
                root = root.left; // move on to left child 
            }
            
            // At this point, we ran out of left children
            root = stack.pop(); // Record the root value into res
            res.add(root.val);
            root = root.right; // Start looking for the right
        } // this keeps going until the stack is empty
        return res;
    }
    
}


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
