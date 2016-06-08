public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] sum = new int[nums.length];
        int max = Integer.MIN_VALUE;
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
            for(int j=-1; j<i; j++){
                int temp;
                if(j==-1){
                    temp = sum[i];
                }else{
                    temp = sum[i] - sum[j];
                }
                
                if(temp>max){
                    max = temp;
                }
            }
        }
        
        return max;
        
    }
}