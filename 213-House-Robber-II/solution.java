public class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int[] nums, int start, int end){
        int len = end-start+1;
        int res[] = new int[len];
        for(int i=start; i<=end; i++){
            res[i-start] = nums[i];
        }
        
        for(int i=1; i<len; i++){
            int tmp = 0;
            for(int j=0; j<=i-2; j++){
                tmp = Math.max(res[j], tmp);
            }
            res[i] += tmp;
        }
        
        int max = 0;
        for(int i=0; i<len; i++){
            max = Math.max(max, res[i]);
        }
        return max;
    }
}