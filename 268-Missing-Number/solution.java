public class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null){
            return 0;
        }
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        int real = 0;
        for(int i=0; i<==nums.length; i++){
            real += i;
        }
        return real-sum;
    }
}