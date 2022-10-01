/**
 * 0148. Sort List
 * Using merge sort!!
 * Return the linked list in ascending order
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * 1. Using 2pointer / fast-slow pointer find the middle node of the list.
 * 2. Now call mergeSort for 2 halves.
 * 3. Merge the Sort List (divide and conqueror Approach)
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
    // Recursion for divide and conquer
    ListNode* sortList(ListNode* head) {
        // Base case
        if (head == NULL || head -> next == NULL) {
            return head;
        }
        
        ListNode *temp = NULL;
        ListNode *slow = head;
        ListNode *fast = head;
        
        // Find the middle
        while (fast != NULL && fast -> next != NULL) {
            temp = slow; 
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        
        // Cut the list in half
        temp -> next = NULL;
        
        // Recursion go in
        ListNode* L1 = sortList(head);
        ListNode* L2 = sortList(slow);
        
        return mergeList(L1, L2);
    }
    
    // Merge all the single nodes by chaining them depending on values
    ListNode* mergeList(ListNode *L1, ListNode *L2) {
        ListNode *ptr = new ListNode(0);
        ListNode *curr = ptr;
        
        // Traverse the lists and combine in sorted order
        while(L1 != NULL && L2 != NULL) {
            if (L1 -> val <= L2 -> val) {
                curr -> next = L1;
                L1 = L1 -> next;
            } else {
                curr -> next = L2;
                L2 = L2 -> next;
            }
            curr = curr -> next;
        }
        
        // If one of them ran out
        if (L1 != NULL) {
            curr -> next = L1;
        } else {
            curr -> next = L2;
        }
        
        // Return the actual head from virtual head
        return ptr -> next;
    }
};
