# Implement level-order traversal of a tree in Python 3.
"""
Example:
[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
   
Returns:
[
  [3],
  [9,20],
  [15,7]
]
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Recursion base case
        # If there's no more to look for, don't return anything
        if root is None:
            return[]
        
        # Create an empty list to store results
        result = []
        
        # Recursive function with the current level and root
        def populate_result(level, node):
            # If we need to expand the size of result([])
            if level > len(result) - 1:
                result.append([])
                
            result[level].append(node.val)
            
            # Recursively traverse all the none-null children
            if node.left:
                populate_result(level + 1, node.left)
            if node.right:
                populate_result(level + 1, node.right)
                
        populate_result(0, root)
        return result
    
    # Time complexity: O(N)
    # Space complexity: O(N)
