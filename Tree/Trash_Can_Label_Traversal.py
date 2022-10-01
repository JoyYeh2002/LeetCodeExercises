# Use GRAY and WHITE colors to label tree node traversals
# WHITE: a node hasn't been visited
# GRAY: visited once but the children are not completely visited
# BLACK: everything under it is visited. Can output from stack.
# In-order, pre-order, and post-order: simply change the order of stack pushes (draw a diagram)!

class Solution:
  def inorderTraversal(self, root: TreeNode) -> List[int]:
    WHITE, GRAY = 0, 1
    res = []
    stack = [(WHITE, root)]
    
    while stack:
      color, node = stack.pop();
      
      # Base case (leaf)
      if node is None: continue
        
      # Push elements in stack with in-order order
      if color == WHITE:
        stack.append((WHITE, node.right))
        stack.append((GRAY, node))
        stack.append((WHITE, node.left))
      
      # Entirely-visited node: send output
      else:
        res.append(node.val)
    return res
