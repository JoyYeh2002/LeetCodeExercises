# 105. Construct Binary Tree from Pre-Order and In-Order Traversal
# Time complexity O(N)
# Space complexity O(N)
'''
Example: 
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        
        # The first elem of pre-order has to be the root
        root = TreeNode(preorder[0])

        # Find this root in in-order. (L, Root, R)
        # Then all the elements to the left are L children, right vise versa.
        i = inorder.index(root.val)
        # Now they're identified, do recursion on the sub-arrays in their target directions
        root.left = self.buildTree(preorder[1:i + 1], inorder[:i])
        root.right = self.buildTree(preorder[i + 1:], inorder[i+1:])

        return root
        
