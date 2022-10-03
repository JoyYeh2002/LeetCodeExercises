# BFS templates for 1. labeling the current level 2. not labeling

# 1. Label the levels and using a dequeue
class Solution:
  def bfs(k):
    queue = collection.dequeue([root])
    steps = 0
    ans = []
    
    while queue:
      size = len(queue)
      for _ in range(size):
        node = queue.popleft() # this is a dequeue operation
        if (step == k) ans.append(node)
        if node.right:
          queue.append(node.right)
        if node.left:
          queue.append(node.left)
      steps += 1
    return ans
  
# 2. No Labeling
class Solution:
  def bfs(k):
    queue = collections.deque([root])
    while queue:
      node = queue.popleft()
      
      # No need to use steps
      if (node is target) return nod
      if node.right:
        queue.append(node.right)
      if node.left:
        queue.append(node.left)
        
    # Otherwise, not found
    return -1
    
