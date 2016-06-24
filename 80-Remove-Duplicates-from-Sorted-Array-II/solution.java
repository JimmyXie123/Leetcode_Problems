public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        int slow=0, fast=0;
        int flag=1;
        int len = nums.length;
        while(fast<len){
            if(nums[slow]!=nums[fast]||(nums[slow]==nums[fast]&&slow!=fast)){
                if(nums[slow]==nums[fast]&&flag>=2){
                    continue;
                }else if(nums[slow]==nums[fast]&&flag<2){
                    flag++;
                }else{
                    flag = 1;
                }
                nums[++slow] = nums[fast++];
            }else{
                nums[slow] = nums[fast++];
            }
        }
        
        return slow+1;
        
    }
}