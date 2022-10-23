# 0719: Find the k-th smallest distance between number pairs
# Keep a max-heap of size k while iterating over the entire matrix
# Heap stores 3 stuff: the difference, the curr idx, and the next idx

class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        nums.sort()
        # h is a tuple array
        h = [(nums[i+1] - nums[i], i, i+1) for i in range(len(nums) - 1)]
        heapq.heapify(h)
        
        # Do the same thing k times to pop until the kth element from heap
        for _ in range(k):
            diff, fr, to = heapq.heappop(h)
             
            # If we can keep going, change the to pointer
            if to + 1 < len(nums):
                heapq.heappush(h, (nums[to + 1] - nums[fr], fr, to + 1))
        
        return diff
        '''
        h = []
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                a, b = nums[i], nums[j]
                
                if len(h) == k and -abs(a - b) > h[0]:
                    heapq.heappop(h)
                if len(h) < k:
                    heapq.heappush(h, -abs(a - b))
        
        return -h[0]
        '''
