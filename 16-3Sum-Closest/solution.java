public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3){
            return target;
        }
        int depth = Integer.MAX_VALUE;
        int result = target;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(depth>Math.abs(sum-target)){
                    depth = Math.abs(sum-target);
                    result = sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return target;
                }
            }
        }
        
        return result;
    }
}