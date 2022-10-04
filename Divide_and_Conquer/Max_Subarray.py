# Template for the maximum subarray recursive implementation
# The best subarray can either be in the L, R, or middle.
# When we're combining the middle, we know that the L and R side of it must also be the best L and R.
# Otherwise, there's a contradiction.

# Runtime:
# T(n) = theta(1) if n = 1
#      = 2 * T(n/2) + theta(n) otherwise
# T(n) = theta(n * log(n))

def findMaxSubArray(A, low, high)
  # Base case: only has one element
  if low == high:
    return A[low]
  # Get midpoint to divide
  else mid = (low + high) / 2
    # Divide
    (left_low, left_high, left_sum) = findMaxSubArray(A, low, mid)
    (right_low, right_high, right_sum) = findMaxSubArray(A, mid + 1, high)
    (cross_low, cross_high, cross_sum) = findMaxSubArray(A, low, mid, high)
    
    # Compare and return
    # Case 1: L is the best subarray
    if left_sum >= right_sum and left_sum >= cross_sum:
      return (left_low, left_high, left_sum)
    
    # Case 2: R is the best
    elif right_sum >= left_sum and right_sum >= cross_sum:
      return (right_low, right_high, right_sum)
    
    # Case 3: Cross sum wins
    else:
      return (cross_low, cross_high, cross_sum)
 
# Find max crossing subarrau: get the best L and R and then combine them
# Works if the mid indices overlap
# This is not recursive!!
# Runtime: theta(n), space: theta(n)

def findMaxCrossingSubArray(A, low, mid, high):
  left_sum =  Double.NEGATIVE_INFINITY
  sum = 0
  
  # Start from the left and look for the best sum
  for i in range(mid, low, -1):
    sum = sum + A[i]
    
    # Only updates when a better alternative is found
    if sum > left_sum:
      left_sum = sum
      max_left = i
    
    # Do the same for the right sum
    right_sum = DOuble.NEGATIVE_INFINITY
    sum = 0
    for j in range(mid+1, right+1):
      sum = sum + A[j]
      if sum > right_sum:
        right_sum = sum
        max_right = j
    
    # Return the best combined cross array.
    return (max_left, max_right, left_sum + right_sum)
  
  
    
  
     
  

