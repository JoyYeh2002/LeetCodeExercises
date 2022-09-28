/**
 * 0086. Partition List
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Split into 2 dummy lists and then concatenate them
 * Cycles might appear!
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
    public ListNode partition(ListNode head, int x) {
        
        // Special case
        if (head == null || head.next == null) {
            return head;
        }
        
        // Create left and right dummy arrays
        ListNode L = new ListNode();
        ListNode R = new ListNode();
        
        ListNode Lptr = L;
        ListNode Rptr = R;
        
        // Traverse the entire list
        while (head != null) {
            // Partition into L or R based on x value
            if (head.val < x) {
                Lptr.next = head;
                Lptr = Lptr.next;
            } else {
                Rptr.next = head;
                Rptr = Rptr.next;
            }
            
            // Move on
            head = head.next;
        }
        
        // Combine the two lists. Be careful about cycles!!
        // Note that it's R.next because R.next is a virtual head.
        Lptr.next = R.next;
        Rptr.next = null;
        
        // Return L.next because L is a virtual head.
        return L.next;
    }
}



/*
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        // Special case
        if (head == null || head.next == null) {
            return head;
        }
        
        // Create left and right dummy arrays
        ListNode L = new ListNode();
        ListNode R = new ListNode();
        
        ListNode Lptr = L;
        ListNode Rptr = R;
        
        // Traverse the entire list
        ListNode cur = head;
        while (cur.next != null) {
            // Partition into L or R based on x value
            if (cur.val < x) {
                Lptr.next = new ListNode(cur.val);
                Lptr = Lptr.next;
            } else {
                Rptr.next = new ListNode(cur.val);
                Rptr = R.next;
            }
            
            // Move on
            cur = cur.next;
        }
        
        // Combine the two lists
        Lptr.next = R;
        Rptr.next = null;
        
        // Return
        return L;
    }
}
*/
