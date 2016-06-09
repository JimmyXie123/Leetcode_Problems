public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }   
        int slow = 0;
        int fast = 0;
        int size = nums.length;
        while(fast<nums.length){
            if(nums[fast]==val){
                fast++;
                size--;
            }else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        System.out.println(size);
        return size;
    }
}