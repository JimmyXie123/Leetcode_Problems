//--------类似于subsets dfs的思想----------------
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null){
            return 0;
        }
        
        int fast = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            while(fast<nums.length&&sum<s){
                sum += nums[fast++];
            }
            if(sum>=s){
                res = Math.min(res, fast-i);
            }
            sum -= nums[i];
        }
        
        if(res==Integer.MAX_VALUE){
            return 0;
        }else{
            return res;
        }
        
    }
}