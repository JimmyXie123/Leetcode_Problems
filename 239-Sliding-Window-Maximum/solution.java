public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList();
        
        int i=0;
        int count=0;
        for(int now: nums){
            i++;
            while(!deque.isEmpty()&&now>deque.peekLast()){
                deque.pollLast();
            }
            deque.offer(now);
            if(i>k&&deque.peekFirst()==nums[i-k-1]){
                deque.pollFirst();
            }
            if(i>=k) res[count++] = deque.peekFirst();
        }
        
        return res;
        
    }
}