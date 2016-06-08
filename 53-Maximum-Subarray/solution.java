public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null){
            return 0;
        }
        int[] sum = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum[i] = 0;
            for(int j=0; j<=i; j++){
                sum[i] = sum[i] + nums[j];
            }
            for(int j=-1; j<i; j++){
                if(j==-1){
                    int temp = sum[i];
                }else{
                    int temp = sum[i] - sum[j];
                }
                
                if(temp>max){
                    max = temp;
                }
            }
        }
        
        return max;
        
    }
}