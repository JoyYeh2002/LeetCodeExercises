/* Implement all functions of a heap with a balanced & complete binary tree. 
 * Pre: Initial point is 1
 * Then the childrens are i << 1 and i << 1 + 1
 * Shiftdown, shift up
 
 */
import java.util.Arrays;
import java.util.Comparator;

public class Heap {

    int size = 0;
    int queue[];

    public Heap(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
      
        // Use a queue [3] -> [4] -> [8] -> [9] -> [14] -> [10] -> [11]
        this.queue = new int[initialCapacity];
    }

    public Heap(int[] arr) {
        size = arr.length;
      
        // It's better to store elements starting from idx = 1 for easier indexing (for children, idx = 2 * i  and 2 * i + 1, respectively.
        queue = new int[arr.length + 1];
        int i = 1;
        for (int val : arr) {
            queue[i++] = val;
        }
    }

    public void shiftDown(int i) {
        int temp = queue[i];

        while ((i << 1) <= size) {
            int child = i << 1;
            // child!=size can determine if a right child is present
            // If there isn't a right child or the order is correct, move on to the next child target
            if (child != size && queue[child + 1] < queue[child]) {
                child++;
            }
            if (temp > queue[child]) {
                // Swap the element and go to the child index
                queue[i] = queue[child];
                i = child;
            } else {
                break;
            }
        }
        // now the child position gets the temp value (original value)
        queue[i] = temp;
    }

    public void shiftUp(int i) {
        int temp = queue[i];
        // >> is the signed right shift operator
        // These can find direct children
        while ((i >> 1) > 0) {
            if (temp < queue[i >> 1]) {
                queue[i] = queue[i >> 1];
                i >>= 1;
            } else {
                break;
            }
        }
        queue[i] = temp;
    }

    // it's like calling numbers at In-N-Out
    public int peek() {

        int res = queue[1];
        return res;
    }

    public int pop() {

        int res = queue[1];
        // Shrink the queue and shift down the first element as appropriate
        queue[1] = queue[size--];
        shiftDown(1);
        return res;
    }

    public void push(int val) {
        if (size == queue.length - 1) {
            queue = Arrays.copyOf(queue, size << 1+1);
        }
        // Insert the new vlaue
        queue[++size] = val;
      
        // Arrange positions
        shiftUp(size);
    }

    public void buildHeap() {
        // >> means dividing by 2
        for (int i = size >> 1; i > 0; i--) {
            shiftDown(i);
        }
    }

    public static void main(String[] args) {

        int arr[] = new int[]{2,7,4,1,8,1};
        Heap heap = new Heap(arr);
        heap.buildHeap();
        System.out.println(heap.peek());
        heap.push(5);
        while (heap.size > 0) {
            int num = heap.pop();
            System.out.printf(num + "");
        }
    }
}
