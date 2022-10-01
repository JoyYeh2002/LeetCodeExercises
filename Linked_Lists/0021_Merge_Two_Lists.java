/**
 * 0021. Merge Two Sorted Lists
 * Move 3 pointers at once.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a new head
        ListNode head = new ListNode();
        
        // Book-keeping on 3 lists so we need to move 3 pointers
        ListNode ptr = head, ptr1 = list1, ptr2 = list2;
        
        // When both have elements
        while (ptr1 != null && ptr2 != null) {
            // Choose which to place, move their pointers if successful
            if (ptr1.val < ptr2.val) {
                ptr.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                ptr.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next; 
            }
            // Move the main result pointer
            ptr = ptr.next;
        }
        
        // When one of them is done, just link the rest to the result list
        if (ptr1 != null) {
            ptr.next = ptr1;
        } else {
            ptr.next = ptr2;
        }
        
        // head is a virtual head, so only next has actual content.
        return head.next;
    }
}

/*
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        
        // Define the head after comparison
        if (list1.val < list2.val) {
            head = new ListNode(list1.val, null);
        } else {
            head = new ListNode(list2.val, null);
        }
        
        // Start looking through all elements
        while (cur1 != null && cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
            
            if (list1.val < list2.val) {
                ptr.next = new ListNode(list1.val, null);
            } else {
                ptr.next = new ListNode(list2.val, null);
            }
            ptr = ptr.next;
        }
        
        // Now one them is finished. Just combine the rest to the result list
        if (cur1 != null) {
            ptr.next = cur1;
        } else {
            ptr.next = cur2;
        }
        return head;
    }
}
*/
