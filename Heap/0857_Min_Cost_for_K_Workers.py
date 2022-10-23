""" 857. Worker Wages
# Sort by unit ratio first
# Then, in a max heap, keep removing the most productive workers while maintaining k people total
# This ensures the least amount of cost
#
# We can reach the minumum when we're giving a constant hourly rate according to the lowest-offering price.
# Use min heaps
#
# Time: O(NlogN + Nlogk)
#
There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.

"""
class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        # Modify the workers list to store pairs of info:
        # The unit wage ratio and their actual amount of work
        # for q, w in zip(quality, wage) means creating tuples
        workers = [[w/q, q] for q, w in zip(quality, wage)]
        workers.sort()
        
        maxHeap = []
        totalQuality = 0
        minCost = math.inf
        
        # r means ratio (w / q)
        for r, q in workers:
            # -q makes it a max heap
            heappush(maxHeap, -q)
            totalQuality += q
            
            if len(maxHeap) > k:
                totalQuality += heappop(maxHeap)
            if len(maxHeap) == k:
                # min() updates if needed, since r keeps changing
                minCost = min(minCost, totalQuality * r)
        return minCost
    
          
