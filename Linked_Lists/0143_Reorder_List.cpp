/**
 * 143. Reorder List
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * 
 * Use fast and slow pointers to find the center
 * Then recursion to flip the second half
 * Merge the two lists (slow) and (fast) with a temp address pointer
 *
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    
    // Recursion to reverse everything after cur
    ListNode* reverse(ListNode* cur) {
        // Base case (reached the center of reversal)
        if (cur -> next == NULL) return cur;
        
        // Recurse inward
        auto node = reverse(cur -> next);
        
        // Imagine the middle array is all taken care of. Append the curr to the end
        cur -> next -> next = cur;
        
        // Prevent cycles
        cur -> next = NULL;
		
        return node;
    }
    
    void reorderList(ListNode* head) {
        if (!head -> next) return;
        auto slow = head, fast = head -> next;
        
        // Slow fast pointers to find the middle
        while (fast and fast -> next) {
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        
        // Reverse the second half (modify the nodes after fast)
        fast = reverse(slow -> next);
        
        // Cut the first half off and let "slow" save it
        slow -> next = NULL;
        slow = head;
        
        // Iteratively combine the two lists into a new one
        while (fast) {
            // Save the 2nd slow element (keep the address)
            auto temp = slow -> next;
            
            // Insert from the fast element
            slow -> next = fast;
            
            // Move on (jump to the stored address)
            slow = temp;
            
            // temp now saves the next fast (keep the fast address)
            temp = fast -> next;
            
            // Insert a slow, which is temp
            fast -> next = slow;
            
            // retrieve the temp value from the next fast
            fast = temp;
        }
    }
};
