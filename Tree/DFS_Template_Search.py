# A template for DFS searching
# Attention: Beginning, end, and target

# 1. Searching for a single path wiht dfs
def dfs(root, path):
  # Empty node
  if not root: return
  
  # Leaf
  if not root.left and not root.right: return
  path.append(root)
  
  # Main logic here for pre-order traversal
  
  # Then recursion
  dfs(root.left)
  dfe(root.right)
  
  # Pop out the path otherwise the un-related left child will be included
  path.pop()
  
  # Alternatively, the logic can go here for post-order traversal
  
  # Return
  return target

# 2. Searching for all paths with hard-coding
# Problem description: Given a binary tree and an int, 
# return all the paths where the sum of node values equal to the int.
class Solution:
  def pathSum(self, root: TreeNode, target:int) -> List[List[int]]:
    
    # Remain starts with the target sum and reduce with each recursive step
    def backtrack(nodes, path, cur, remain):
      # Empty node
      if not cur: return
      
      # Leaf
      if cur and not cur.left and not cur.right:
        if remain == cur.val:
          nodes.append((path + [cur.val]).copy())
        return
      
      # Select the curr val and add to path
      path.append(cur.val)
      
      # Recursion on children
      backtrack(nodes, path, cur.left, remain - cur.val)
      backtrack(nodes, path, cur.right, remain - cur.val)
      
      # De-select [?]
      path.pop(-1)
    
    ans = []
    backtrack(ans, [], root, target)
    return ans
