/* 0313. Super Ugly Number
 * Find all the ugly numbers starting from 1, then use a priority queue to poll until the nth one.
 * To generate the ugly number, just multiply ans by each element of the primes array.
 *
A super ugly number is a positive integer whose prime factors are in the array primes.

Given an integer n and an array of integers primes, return the nth super ugly number.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

Example 1:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
*/

import java.util.PriorityQueue;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;
        long ans = 1;
        
        pq.add(ans);
        
        while (count < n) {
            
            // Get the current top value of the min heap
            ans = pq.poll();
            
            // If this is the same as the enxt vlaue, throw the next one out to prevent repeats
            while (!pq.isEmpty() && ans == pq.peek()) {
                pq.poll();
            }
            
            count++;
            
            // In each round, generate ans * primts[i] and place into the pq.
            for (int i = 0; i < primes.length; i++) {
                pq.offer(ans * primes[i]);
            }
        }
        return (int)ans;
            
    }
}
