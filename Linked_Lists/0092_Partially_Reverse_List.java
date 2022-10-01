/**
 * 0092. Reverse a portion of the linked list marked at certain L and R indices
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // dummy node (virtual head)
        ListNode dummy = new ListNode(0); 
        dummy.next = head;
        
        // Move prev all the way to the L flip edge
        ListNode prev = dummy; 
        for(int i = 0; i < left - 1; i++)
            prev = prev.next; 
        
        // Curr is the first element it grabs
        ListNode curr = prev.next; 
        
        // Reverse (R - L) number of times
        /* [3] --> [4] --> [5] --> [6]
         * curr    next   next.next
         *
         * [3] --> [5]
         * [4] --> [3] --> [5] next.next = prev.next
         * [2] --> [4] --> [3] --> [5] prev.next = next
         * prev            curr    next
         * [2] --> [6] --> [5] --> [4] --> [3] --> [18]
         *                         curr   next.next
         */
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next; 
            
            // Take out the next node and re-chain
            curr.next = next.next;
            
            // Re-insert "next" right after prev
            next.next = prev.next;
            
            // Link "next" up with the left edge
            prev.next = next;
            
            // At this point, "curr" already moved to the right by 1!!
            // So the for-loop can keep going.
        }
        return dummy.next;
    }
}
