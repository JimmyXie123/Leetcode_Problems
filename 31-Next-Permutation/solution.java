public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)  return;
        int len = nums.length;
        for(int i=len-2; i>=0; i--){
            if(nums[i+1]>nums[i]){
                for(int j=len-1; j>i; j--){
                    if(nums[j]>nums[i]){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        reverse(nums, i+1, len-1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, len-1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++; 
            end--;
        }
    }
}