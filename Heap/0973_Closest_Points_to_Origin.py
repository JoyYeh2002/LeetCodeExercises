# 973. K-closest points to origin
# We can calculate the distance for each point
# Then, push the [distance, coords] pair into a min heap
# Then, poll k times and add into the ans array

import math

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        res = []
        
        
        '''
        Method 1: Make a min heap then poll k times
        
        min_heap = []
        
        # Make a min heap
        for i, j in points:
            x = i*i + j*j
            heapq.heappush(min_heap, (x, [i, j]))
        
        # Do all the polling
        for _ in range(k):
            popped = heapq.heappop(min_heap)
            res.append(popped[1])
            
        return res
        '''
        
        '''
        Method 2: Maintain a max heap of size k
        '''
        
        for i, j in points:
            x = i*i + j*j
            
            if len(res) < k:
                heapq.heappush(res, (-x, [i, j]))
            else:
                # heappushpop is pushing first, then popping
                heapq.heappushpop(res, (-x, [i, j]))
            
        # Outputs the entire list of every coords pair
        # retun [x[1] for x in res]
        return [x[1] for x in res]
        ''' Old Solution: Didn't work
        
        # Grab x[1]'s, which are the coordinate pairs [i j]
        return [x[1] for x in res]
    
        
        # Store all the distances
        distances = {}
        for i, pt in points:
            distances[i] = math.sqrt(pt[0]**2 + pt[1]**2)
            
        # Place into min heap
        heap = []
        
        for key in distances:
            heapq.heappush(heap, (distances[i], key))
            
        res = []
        for _ in range(k):
            popped = heapq.heappop(heap)
            res.append(popped[2])
        
        return res
        '''
        
        
        
