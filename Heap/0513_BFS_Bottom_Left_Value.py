# 0513. Find the bottom left value of a tree.
# Use BFS from right to left with a queue
# Push the root in, then push in right, then left
# Through each while loop iteration, look at the poll() element's right and left kids.
# Push them as well, until we reach the very last element in the queue
# Which is the leftmost bottom leaf. 
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return None
        queue = collections.deque([root])
        
        # ans is a node
        ans = None
        
        while queue:
            size = len(queue)
            for _ in range(size):
                ans = node = queue.popleft()
                if node.right:
                    queue.append(node.right)
                if node.left:
                    queue.append(node.left)
        return ans.val
