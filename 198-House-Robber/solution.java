public class Solution {
    public int rob(int[] nums) {
        if(nums==null){
            return 0;
        }
        
        int res[] = new int[nums.length];
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            res[i] = nums[i];
        }
        
        for(int i=1; i<len; i++){
            int tmp = 0;
            for(int j=0; j<=i-2; j++){
                tmp = Math.max(tmp, res[j]);
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