/**
 * 0234. Palindrome Linked List
 * Push everything into a stack and queue at once
 * Since we have FIFO and LIFO, stack elements' revealing order will be reversed when we keep calling s.top()
 * So we can compare the elements. s.top() and q.front() all have to match
 * Syntax: !s.empty() and !q.empty()
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
    bool isPalindrome(ListNode* head) {
        stack<int> s;
        queue<int> q;
        
        // Populate the stack and queue
        ListNode *temp = head;
        while (temp) {
            s.push(temp -> val);
            q.push(temp -> val);
            temp = temp -> next;
        }
        
        // Take elements out and compare them
        while (!s.empty() || !q.empty()) {
            if (s.top() != q.front()) {
                return false;
            }
            
            s.pop();
            q.pop();
        }
        return true;
    }
};
