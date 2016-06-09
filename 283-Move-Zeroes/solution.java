public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<2){
            return;
        }
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(nums[fast]==0){
                fast++;
            }else{
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
                fast++;
            }
        }
    }
}