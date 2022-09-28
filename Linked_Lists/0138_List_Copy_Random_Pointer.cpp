/*
* 0138. Copy List with Random Pointer
* Create a deep copy of a linked list when it has a random ptr attribute that points to another place in the original list.
* Passed 3 times, O(N)
* 
* Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        
        // Pass 1
        // Create a copy: A -> A' -> B -> B' -> C -> C' -> ...
        Node* node=head;
        while (node) {
            // Insert node A' with everything copied but the random ptr
            Node* temp = node -> next;
            node -> next = new Node(node -> val);
            
            // Move on to old node B
            node -> next -> next = temp;
            node = temp;
        }
    
        // Pass 2
        // Now copy the random pointer (if exists) of the old nodes to their copy new nodes.
        node = head;
        while (node) {
            // Node -> next means A'
            // Node -> random -> next is another old node, say node D
            if (node -> random)
                node -> next -> random = node -> random -> next;
            
            // Jump twice to get to node B
            node = node -> next -> next; 
        }
        
        // Pass 3
        // Copy the alternative nodes into "ans" linked list
        // "helper" ptr also restores the old link list.
        Node* ans = new Node(0); 
        Node* helper = ans;
    
        while (head) {
            // Only get the A', B', C', ...
            helper -> next = head -> next;
            
            // Move on
            helper = helper -> next;
            
            // Remove all the A', B' by skipping levels
            head -> next = head -> next -> next;
            
            // Move on
            head = head -> next; 
        }
        return ans -> next; // Since first node is dummy
    }
};
