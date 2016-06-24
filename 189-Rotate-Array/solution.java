public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null){
            return;
        }
        int len = nums.length;
        k = k%len;
        
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
        
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}