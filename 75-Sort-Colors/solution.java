public class Solution {
    public void sortColors(int[] nums) {
        //int[] result = new int[nums.length];
        if(nums.size<2){
            return;
        }
        int mid = nums.length/2;
        int[] left = new int[nums.length/2];
        int[] right = new int[nums.length-nums.length/2];
        for(int i=0; i<nums.length/2; i++){
            left[i] = nums[i];
        }
        for(int i=nums.length/2; i<nums.length; i++){
            right[i-nums.length/2] = nums[i];
        }
        sortColors(left);
        sortColors(right);
        nums = merge(left, right);
        
    }
    
    private int[] merge(int[] left, int[] right){
        if(left.length<=0||right.length){
            return
        }
        int[] result = new int[left.length+right.length];
        int i=0, j=0, l=0;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                result[l] = left[i];
                l++; 
                i++;
            }else{
                result[l] = right[j];
                l++;
                j++;
            }
        }
        while(i>=left.length&&j<right.length){
            result[l++] = right[j++];
        }
        while(i<left.length&&j>=right.length){
            result[l++] = left[i++];
        }
        return result;
    }
}