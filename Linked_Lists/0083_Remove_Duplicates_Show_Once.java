/**
 * 0083. Remove Duplicates in Linked List
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * Use a pointer to traverse the array. Connect cur.next.next if the .next value is the same
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
        
        // Special case
        if (head == null || head.next == null) {
            return head;
        }
        
        // Use ptr to manage the result array
        ListNode ptr = head;
        
        while (ptr != null && ptr.next != null) {
            // If need to skip element, link with the next element after skipping
            if (ptr.next.val == ptr.val) {
                ptr.next = ptr.next.next;
                
            // Do a normal chaining and move on
            } else {
                ptr = ptr.next;
            }
        }
        
        // At the end, return the original head.
        return head;
    }
}
