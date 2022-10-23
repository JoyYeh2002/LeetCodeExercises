# 1046: Last Stone Weight
# Python implementation with heaps
#
# Syntax:
# for i, s in enumarate(stones) List[int]
# stones[i] = -s
#
# heapify(stones)
# heappop(stones)
# heappush(stones)

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        # Invert everything for max heap
        # for i, s in enumerate(stones) 
        # i is idx, s is the actual element
        for i, s in enumerate(stones):
            stones[i] = -s
            
        # This is built-in. Stones is now a heap
        heapify(stones)
        
        while stones:
            s1 = - heappop(stones)
            
            # If this empties out the heap, return s1 (the last elem)
            if not stones:
                return s1
            
            s2 = -heappop(stones)
            if s1 > s2:
                heappush(stones, s2 - s1)
            
            # else s1 == s2, we just discard both by popping and not do anything
        return 0 # Base case: no stone remains
        
