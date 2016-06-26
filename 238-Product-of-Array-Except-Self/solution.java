public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null){
            return null;
        }
        int[] f = new int[nums.length];
        f[f.length-1] = nums[nums.length-1];
        
        for(int i=nums.length-2; i>=0; i--){
            f[i] = nums[i] * f[i+1];
        }
        
        int[] res = new int[nums.length];
        int ahead = 1;
        for(int i=0; i<nums.length; i++){
            if(i<nums.length-1){
                res[i] = ahead*f[i+1];
                ahead *= nums[i];
            }else{
                res[i] = ahead;
            }
        }
        return res;
    }
}