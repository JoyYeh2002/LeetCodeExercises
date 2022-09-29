/**
 * 0141. Checking cycles in linked list
 * Use fast and slow pointers to check if they ever collide
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
    public boolean hasCycle(ListNode head) {
        // Special case
        if (head == null) return false;
        
        // Use two pointers and check if they ever meet back
        ListNode slow = head;
        ListNode fast = head.next;
        
        // Traverse and see if they collide
        while (slow != fast) { 
            
            // If one of those three fell out, meaning they reached the ending
            // Then there's no cycles
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            
            slow = slow.next;
            
            // Note that a "fast" pointer MOVES QUICKLY and jumps 2 spots in each iteration
            fast = fast.next.next;
        }
        
        // At some point, slow == fast
        return true;
    }
}

/*
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return false;
        }
        
        // Keep going next and assigning pos in a new ptr list
        ListNode ptr = head;
        ptr.val = 0;
        
        // Keep a pos set
        ArrayList<Integer> idx = new ArrayList<Integer>();
        
        // Assign positions to each node
        int currPos = 1;
        
        // While we haven't found a same pos
        while (ptr.next != null) {
            ptr.next = new ListNode(currPos);
            currPos++;
            
            if (idx.contains(ptr.next.val)) {
                 return true;
             }              
        }
        return false;
    }
}
*/
