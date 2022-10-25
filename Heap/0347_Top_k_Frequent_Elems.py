# 0347: top k frequent elements
# It's ok to push a key value pair into a heap
#
# We are comparing by frequency items[key], so that it put at the front.
# heapq.heappush(heapName, [stuff to put, could be tuples])
#
# for key in items:
#   heapq.heappush(heap, (-items[key], key))

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        items = {}
        
        # Create a dict that stores num : frequency pair
        for item in nums:
            if item in items:
                items[item] += 1
            else:
                items[item] = 1
                
        heap = []
        
        # Create a max heap (negated) with the "value, key pair"
        for key in items:
            heapq.heappush(heap, (-items[key], key))
                
        # the res array catches all the popped elements
        res = []
        for _ in range(k):
            popped = heapq.heappop(heap)
            res.append(popped[1])
            
        return res
    
        '''
        # Now, max heapify this dict according to values
        heap_items = []
        for i in items.values():
            heap_items.append(i)
        heapq.heapify(heap_items)
        
        # poll k times and return the key with that frequency
        for j in range(k - 1):
            heappop(heap_items)
        target = heappop(heap_items)
        return items.keys()[items.values().index(target)]
        '''
        
