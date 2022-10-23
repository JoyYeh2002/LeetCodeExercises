# 0871: Least amount of gas refill
# Keep going as long as the current gas amount >0
# Otherwise, go back to the max heap to find the best gas stations

class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        
        # Add the destination into the stations list with 0 fuel
        stations += [(target, 0)]
        
        # Record the current fuel amount
        cur = startFuel
        ans = 0
        
        h = []
        last = 0
        
        for i, fuel in stations:
            
            # Subtract by the amount used after coming from the last station
            cur -= i - last
            
            # Now we look back and see where we should've added gas
            while cur < 0 and h:
                cur -= heapq.heappop(h)
                ans += 1
                
            # If we really nead gas but the heap is already empty
            # Then it's not possible to make it
            if cur < 0:
                return -1
            
            # Max heap with the best station on top
            heappush(h, -fuel)
            
            # Update the last station
            last = i
        return ans
                
