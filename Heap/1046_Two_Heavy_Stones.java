/* 1046. Last Stone Weight: Elementary usage of a maxHeap with priority queue
 * import java.util.PriorityQueue;
 * PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, (a, b) -> b - a));
 
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.
*/

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        
        // O(log(n)) time implementation
        // initial capacity, comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, (a, b) -> b - a);
        
        // Alternatively:
        // PriorityQueue<Integer> maxHeap = new PriorityQueue.reverseOrder());
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Put everything into the maxHeap
        // Then the heaviest stone is on top
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        while (maxHeap.size() >= 2) {
            Integer head1 = maxHeap.poll();
            Integer head2 = maxHeap.poll();
            
            // Crush both stones (throw out of the heap) if both are the same weight
            if (head1.equals(head2)) {
                continue;
            }
            
            maxHeap.offer(head1 - head2);
        }
        
        if (maxHeap.isEmpty()) {
            return 0;
        }
            
        // Return the last remaining stone weight
        return maxHeap.poll();

    }
}
