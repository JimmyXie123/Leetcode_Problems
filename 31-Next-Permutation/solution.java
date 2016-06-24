public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null){
            return;
        }
        int len = nums.length;
        for(int i=len-2; i>=0; i--){
            if(nums[i+1]>nums[i]){
                for(int j=len-1; j>i-1; j--){
                    if(nums[j]>nums[i]){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        reverse(nums, i+1, len-1);
                        return;    
                    }
                }
            }
        }
        reverse(nums, 0, len-1);
    }
    
    private void reverse(int[] nums, int start, int end){
        for(int i= start, j=end; i<j; i++, j--){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}