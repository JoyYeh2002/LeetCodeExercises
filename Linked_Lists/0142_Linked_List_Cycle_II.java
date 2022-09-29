/**
 * 0142. Linked List Cycle II
 * Use fast and slow pointers to determine cycle
 * Then use head ptr and slow to find cycle position
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
    // Special case
    if (head == null) return null;

    ListNode slow = head;
    ListNode temp = head;
    ListNode fast = head.next;
    
    // While it's fine
    while (slow != fast) {
        // If fast successfully fell out, then there's no cycles
        if (fast == null || fast.next == null) 
            return null;
        
        // Move on
        slow = slow.next;
        fast = fast.next.next;      
    }

    // Special treatments for the equal case (when there's actually a cycle)
    /*
       [3] ---> [2] ---> [0] ---> [-4] ---
                 |                       |
                 -------------------------
    */
        
    // We can already determine the presence of a cycle at this step
    
    if (slow == fast) {
        // temp is the original head
        while (slow.next != temp) {
            slow = slow.next;
            temp = temp.next;
        }
        // But if they clash again, we can return temp and know the cycle position
        return temp;
    }
    return null;
           
    }
}


/*
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Special case
        if (head == null) return null;
        
        // Use two pointers and check if they ever meet back
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;
        
        // Traverse and see if they collide
        while (slow != fast) { 
            
            // If one of those three fell out, meaning they reached the ending
            // Then there's no cycles
            if (slow == null || fast == null || fast.next == null) {
                return null;
            }
            
            pre = slow;
            slow = slow.next;
            
            // Note that a "fast" pointer MOVES QUICKLY and jumps 2 spots in each iteration
            fast = fast.next.next;
        }
        
        // At some point, slow == fast
        return pre;
    }
}
*/
