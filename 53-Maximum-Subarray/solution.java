public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum = 0;
        int max=Integer.MIN_VALUE, minSum=0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            max = Math.max(max, sum-minSum);
            minSum = Math.min(sum, minSum);
        }
        return max;
        
    }
}