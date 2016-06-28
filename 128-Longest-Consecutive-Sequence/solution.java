public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int fast = 0;
        int len = 1;
        int res = 1;
        int i=0;
        while(i<nums.length){
            while(fast<nums.length-1&&(nums[fast]+1==nums[fast+1]||nums[fast]==nums[fast+1])){
                if(nums[fast]==nums[fast+1]){
                    fast++;
                    continue;
                }else{
                    fast++;
                    len++;
                }
            }
            fast++;
            i = fast;
            res = Math.max(res, len);
            len = 1;
        }
        
        return res;
    }
}