# 1488. Avoid Flood in the City (Lakes)
# Hard problem!!
# Check all the lakes that WILL be flooded since we can forsee the future. Then, try to take the available days (dry + can drain a wet lake) with bisect.bisect_left(array, targetNum)
# Try to draw out the situation and write the code inward between condition blocks.
# wet_lakes = {}
# sunny = []
# ans = [-1, -1, 2, 3, -1, -1]
#
# Note that the indices i are also lake indices.

class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        ans = [1] * len(rains)
        wet_lakes = {}
        sunny = []
        
        # Traverse through the i (day numbers) and rain (wet lake idx)
        # in the entire rain array
        for i, rain in enumerate(rains):
            # if it rains
            if rain > 0:
                # we can't drain it
                ans[i] = -1
                
                # if the 0-based index (this lake) is already wet
                if rain - 1 in wet_lakes:
                    # Try to find a day to drain out the lake 
                    # from the sunny days list
                    j = bisect.bisect_left(sunny, wet_lakes[rain - 1])
                    
                    # If we can't find any good day
                    if j == len(sunny):
                        # Return "not possible"
                        return []
                    
                    # Otherwise, populate the answer with the specified lake to drain
                    ans[sunny.pop(j)] = rain
                wet_lakes[rain - 1] = i
            # else it didn't rain, we can insert sunny options.
            else:
                sunny.append(i)
        return ans
                    
        
                        
        
