/**
 * 0513. Find tree leftmost value
 * BFS with a queue: push root in, then poll out the earliest element. Push right and left children if they exist
 * Then, the last root in the queue would be the target
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
    public int findBottomLeftValue(TreeNode root) {
        // BFS is done through a queue
        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);
        while (!queue.isEmpty()) {
            // Take the first element out of the queue (curr)
            root = queue.poll();
            // Since our last target is the leftmost node, we want the right node to be examined first so that a left node will be left at last
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
