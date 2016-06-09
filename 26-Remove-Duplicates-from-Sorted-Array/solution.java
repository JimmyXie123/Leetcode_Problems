public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int size = nums.length;
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if(j>0&&nums[j]==nums[j-1]){
                j++;
                size--;
            }else{
                nums[i] = nums[j];
                j++;
                i++;
            }
            
        }
        /*for(int i=0; i<nums.length; i++){
            while(i>0&&nums[i]==nums[i-1]){
        }*/
        return size;
    }
}