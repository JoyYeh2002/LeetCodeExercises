/**
 * 0082. Remove Duplicates from Sorted List II
 * Manage 3 consecutive pointers. Edge cases
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Take care of base case
        if (head == null) {
          return head;
        }

        // Virtual head
        ListNode newNode = new ListNode();
        newNode.next = head;

        // Temp node is the virtual head
        ListNode temp = newNode;

        // ptr1 and ptr2 must exist
        while (temp.next != null && temp.next.next != null) {
            // "first" starts at the head
            ListNode first = temp.next;
            ListNode second = temp.next.next;

            // Skip all the equal pairs and go to the next ones
            if (first.val == second.val) {
                while (second != null && first.val == second.val) {
                    second = second.next;
                }

                // Re-link at the broken node once found an un-equal node
                // [temp] --> [first] --> 3 --> 3 --> [second] 
                //   1           3                       4    
                //   1 --> 4
                temp.next = second;

                // Keep going
                continue;
            } 

            // Now temp --> second are definitely not the same. Move on.
            // [?] why?
            temp = first;
        }

        // Return the actual head from virtual head
        return newNode.next;
    }
}

/*
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        // Store the answer in res
        ListNode res = head;
        
        // Create two ptrs side-by-side
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        
        // Loop ends when ptr2 gets out of bounds
        while (ptr1 != null && ptr2 != null) {
            
            // Ok case
            if (ptr1.val != ptr2.val) {
                ptr1 = ptr2;
                ptr2 = ptr2.next;
                res.next = new ListNode(ptr1.val);
            } else {
                ptr2 = ptr2.next;
                res.next = new ListNode(ptr1.val);
            }
        }
        return head;
    }
}

*/
