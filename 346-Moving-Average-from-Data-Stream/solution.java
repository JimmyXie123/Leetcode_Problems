public class MovingAverage {
    double prev_sum=0.0;
    Queue<Integer> queue;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList();
        this.size = size;
    }
    
    public double next(int val) {
        if(size==queue.size()){
            prev_sum=prev_sum-queue.poll();
        }
        prev_sum = prev_sum+val;
        queue.offer(val);
        return prev_sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */