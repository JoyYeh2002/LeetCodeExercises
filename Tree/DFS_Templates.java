/* A classic template for implementing Depth-First-Search
 * Algorithm process: 
 * 1. Push the root into the stack
 * 2. Pop from the stack (most recent node) and see if it's the target
 * 3. If so, return the result. Otherwise, add the child into the stack
 * 4. Repeat from step 2
 * 5. If stack becomed empty, return "target not found"
 */

const visited = {}
function dfs(i) {
  if (// Some condition is met) {
    // Return result or leave 
  }
    
  visited[i] = true; // Make the visited label (usually not needed unless the tree structure is modified)
  for (// The next node j) {
    if (!visited[j]) {
      dfs(j) // Do recursion on node j
    }
  }
}
    
// Without the visited[] labels
function dfs(root) {
  if (// Condition is met) {
     // Return result or leave
  }
        
  for (const child of root.children) {
     dfs(child)
  }
}
    
// For binary trees
function dfs(root) {
  if (// Condition is met) {
     // Return result or leave
  }
  
  // Recursive calls
  dfs(root.left)
  dfs(root.right)
}
