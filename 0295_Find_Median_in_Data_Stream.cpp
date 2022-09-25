/* 0295: Find Median from Data Stream
 * Using two queues: a max- and a min-heap to implement a median   
 * number finder because the build-in priority queue functions in 
 * C++ can improve time complexity
 *
 * max_queue sorts the bottom half of the data
 * min_queue sorts the top half
 *
 * When finding the median, only need to take / compare the top 
 * elements of the max and mean queues.
 */
class MedianFinder {
public:
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if (max_queue.empty()) {
            max_queue.push(num);
            return;
        }
        
        // Pick which queue to insert new element into,
        // given that every element in the small queue >= elements
        // in the large queue
        if (max_queue.size() == min_queue.size()) {
            if (num <= max_queue.top()) {
                max_queue.push(num);
            } else {
                min_queue.push(num);
            }
          // Re-organize the two queues to keep balances sizes
        } else if (max_queue.size() > min_queue.size()) {
            // Case 1: move the current max elem of the max_queue into the min_queue
            // Then, put the new num in
            if (max_queue.top() > num) {
                min_queue.push(max_queue.top());
                max_queue.pop();
                max_queue.push(num);
                
            // Case 2: num needs to go into the min_queue
            } else {
                min_queue.push(num);
            }
            
        // Case 3: Other situations of pushing in the new elem
        // Ensures balanced size and comparitive ordering
        } else if (max_queue.size() < min_queue.size()) {
            if (min_queue.top() > num) {
                max_queue.push(num);
            } else {
                max_queue.push(min_queue.top());
                min_queue.pop();
                min_queue.push(num);
            }
        }
    }
    
    // Now, everything are naturally ordered in an efficient way
    double findMedian() {
        if (max_queue.size() == min_queue.size()) {
            return (max_queue.top() + min_queue.top()) * 0.5;
        }
        if (max_queue.size() < min_queue.size()) {
            return min_queue.top();
        }
        return max_queue.top();
    }
    
    private:
    std::priority_queue<int, std::vector<int>, std::greater<int>> min_queue;
    std::priority_queue<int> max_queue;
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
