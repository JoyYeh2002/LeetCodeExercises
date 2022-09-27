# Search the same words from the list and the board
"""
0212. Search Words that show up in both words and board.
Used Trie + recursive DFS
Marked visited nodes to end recursion early.

input:
words = ["oath","pea","eat","rain"]
board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

output: ["eat","oath"]
"""
    
from collections import defaultdict

# Use a Trie implementation + DFS Search
class Trie:
    def __init__(self):
        self.children = defaultdict(Trie)
        self.word = ""

    # Ex: insert "apple"
    # Then a, p, p, l, e will be added to the children
    def insert(self, word):
        cur = self
        for c in word:
            cur = cur.children[c]
        cur.word = word
        
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        def dfs(row, col, cur):
            # Base case: 1. Out of bounds 2. When word is not found 3. When reached an explored element '.'
            if row < 0 or row >= m or col < 0 or col >= n or board[row][col] == '.' or board[row][col] not in cur.children: return
            
            # [?] Look for the current board character in the Trie children
            c = board[row][col]
            cur  = cur.children[c]
            if cur.word != '': ans.add(cur.word)
                
            # Since this element is traversed, mark it
            board[row][col] = '.'
            
            # Recursively go through all other neighbors
            dfs(row+1,col, cur)
            dfs(row-1,col, cur)
            dfs(row,col+1, cur)
            dfs(row,col-1, cur)
            
            # Put the board element back after all recursions
            board[row][col] = c
            
        m, n = len(board), len(board[0])
        
        # A set won't have repeated elements. Convert it into a list at the end
        ans = set()
        
        trie = Trie()
        words = set(words)
        
        # Build the Trie
        for word in words:
            trie.insert(word)
            
        # Use dfs on every element
        for i in range(m):
            for j in range(n):
                dfs(i, j, trie)
        return list(ans)
