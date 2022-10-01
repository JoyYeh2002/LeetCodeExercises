# 106. Construct Binary Tree from In-Order and Post-Order Traversal
# Time complexity O(N)
# Space complexity O(N)
'''
Example: 
preorder = [9, 3, 15, 20, 7]
inorder = [9, 15, 7, 20, 3]
returns

    3
   / \
  9  20
    /  \
   15   7
'''
    
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder:
            return None
        
        # The last elem of post-order has to be the root
        root = TreeNode(postorder[-1])

        # Find this root in in-order. (L, Root, R)
        # Then all the elements to the left are L children, right vise versa.
        i = inorder.index(root.val)
        # Now they're identified, do recursion on the sub-arrays in their target directions
        root.left = self.buildTree(inorder[:i], postorder[:i])
        root.right = self.buildTree(inorder[i + 1:], postorder[i:-1])

        return root
        
