/*
 * 116. Populating a binary tree as a linked list
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 * Spread the linked list from middle outward
 * Connect the center first
 * Then keep going to the two sides, L and R, and keep connecting
 * The links don't have to be made in order, that's why we can complete the whole thing.
 

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // Base case
        if(root == null) return null;
    
        // Main logic creates a linked list
        Node left = root.left;
        Node right = root.right;
    
        // Push left to right and 
        while(left != null){
            left.next = right;
            
            // left.right means "left"'s right child
            left = left.right;
            
            // right's left child will be the "next" that gets linked in the next round
            right = right.left;
        }
    
        // Recurtion on the sides
        connect(root.left);
        connect(root.right);
    
        // Return modified tree
        return root;  
    }
}
