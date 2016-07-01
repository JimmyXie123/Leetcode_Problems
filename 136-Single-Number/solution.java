public class Solution {
    public int singleNumber(int[] nums) {
        int rst = 0;
        for(int i:nums){
            rst ^= i;
        }
        return rst;
    }
}