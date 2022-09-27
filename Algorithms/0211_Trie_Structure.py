"""
0211. Design Add and Search Words Trie Structure
Using Dictionary Trie for
Implement the WordDictionary class:

WordDictionary() Initializes the object.
- void addWord(word) Adds word to the data structure, it can be matched later.
- bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
"""

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Trie = {}

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        curr = self.Trie
        for w in word:
            if w not in curr:
                curr[w] = {}
            curr = curr[w]
        curr['#'] = 1

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        curr = self.Trie
        for i, w in enumerate(word):
            if w == '.':
                wizards = []
                for k in curr.keys():
                    if k == '#':
                        continue
                    wizards.append(self.search(word[:i] + k + word[i + 1:]))
                return any(wizards)
            if w not in curr:
                return False
            curr = curr[w]
        return "#" in curr
     
class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = Trie()

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        self.trie.insert(word)

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        return self.trie.search(word)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
