/**
 * 206. Reverse Linked List
 * Post-order recursion (Assume that the rest of the list is already done)
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
    ListNode* reverseList(ListNode*head) {
        
        // Special case
        if (!head) return NULL;
        
        // Base case (reached center)
        if (head -> next == NULL) return head;
        
        auto node = reverseList(head -> next); 
        
        // Here we assume that the rest of the list is already finished
        // Get the next element, then point its next element to the self to achieve reversal
        head -> next -> next = head;
        head -> next = NULL;
        return node;
    }
};
