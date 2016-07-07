public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if(nums==null){
            return res;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<len-2; i++){
            int left=i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<target){
                    res += right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}