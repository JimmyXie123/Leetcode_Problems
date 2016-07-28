public class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size()>minHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return ((double)maxHeap.peek()+(double)minHeap.peek())/2;
        }else{
            return minHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();