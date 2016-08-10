public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] iNums = new int[n+2];
        iNums[0] = 1;
        iNums[n+1] = 1;
        for(int i=0; i<n; i++){
            iNums[i+1] = nums[i];
        }
        int[][] memo = new int[n+2][n+2];
        return helper(memo, iNums, 0, n+1);
    }
    
    private int helper(int memo[][], int[] iNums, int left, int right){
        if(left+1>=right)   return 0;
        if(memo[left][right]>0)  return memo[left][right];
        for(int i=left+1; i<right; i++){
            memo[left][right] = Math.max(memo[left][right], 
            helper(memo, iNums, left, i)+iNums[left]*iNums[i]*iNums[right]+helper(memo, iNums, i, right));
        }
        return memo[left][right];
    }
}