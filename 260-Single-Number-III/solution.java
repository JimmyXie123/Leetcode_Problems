public class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int num:nums){
            res ^= num;
        }
        
        int num1 = 0, num2 = 0;
        int lastBit = res-(res&(res-1));
        for(int i=0; i<nums.length; i++){
            if((nums[i]&lastBit)==0){
                num1 ^= nums[i];
            }else{
                num2 ^= nums[i];
            }
        }
        
        int[] ans = new int[2];
        ans[0] = num1;
        ans[1] = num2;
        return ans;
    }
}