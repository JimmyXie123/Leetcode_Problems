public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            max[i] = min[i] = nums[i];
            //----------当负数为奇数个或者有0的时候。 动态规划：max[i], min[i]前i个数最大和最小的------------
            if(nums[i]>0){
                max[i] = Math.max(max[i], max[i-1]*nums[i]);  
                min[i] = Math.min(min[i], min[i-1]*nums[i]);
            }else if(nums[i]<0){
                max[i] = Math.max(max[i], min[i-1]*nums[i]);
                min[i] = Math.min(min[i], max[i-1]*nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}