public class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null){
            return 0;
        }
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=i&&nums[i]!=nums.length){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==nums.length){
                return i;
            }
        }
        return nums.length;
    }
}