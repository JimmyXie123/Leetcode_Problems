public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int res[] = new int[nums.length];
        for(int i=0; i<res.length; i++){
            res[i] = 1;
        }
        for(int i=1; i<res.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    res[i] = Math.max(res[i], res[j]+1);
                    if(res[i]>=3)   return true;
                }
            }
        }
        return false;
    }
}