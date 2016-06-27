public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null){
            return 1;
        }
        for(int i=0; i<nums.length; i++){
            while(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=i+1){
                int temp = nums[i];
                if(nums[i]==nums[nums[i]-1]){
                    break;
                }
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}