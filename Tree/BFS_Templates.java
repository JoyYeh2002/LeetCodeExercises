/* Breath-First-Search (BFS) Alrorithm:
 * 1. Push the root into queue
 * 2. Pop and see if it's the target
 * 3. If so, return the result. Otherwise, push all the direct children into the queue
      This makes sure that everything in the same level are pushed in at around the same time, 
      so they will also be poped and examined at the same time, before their children
 * 4. If the queue empties out, returns "target not found"
 * 5. Repeat step 2.
 */

// Template
const visited = {}
function bfs() {
  let q = new Queue()
    q.push(initialCondition)
    while (q.length) {
      let i = q.pop()
      if (visited[i]) continue
      if (i is what we're looking for) return result
          for (next reacheable nodes of i) {
            if (j is legit) {
              q.push(j)
            }
          }
    }
    return notFound
}
       
