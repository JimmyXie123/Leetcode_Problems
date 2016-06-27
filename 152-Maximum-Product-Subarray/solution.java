public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            max[i] = min[i] = nums[i];
            if(nums[i]>0){
                max[i] = max[i-1]*nums[i];
                min[i] = min[i-1]*nums[i];
            }else if(nums[i]<0){
                max[i] = min[i-1]*nums[i];
                min[i] = max[i-1]*nums[i];
            }
            max = Math.max(result, max);
        }
        return result;
    }
}