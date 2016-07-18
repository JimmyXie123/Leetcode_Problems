public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return helper(dp, 1, n);
    }
    
    private int helper(int[][] dp, int low, int high){
        if(low>=high){
            return 0;
        }
        if(dp[low][high]!=0){
            return dp[low][high];
        }
        int tmp = 0;
        int res = Integer.MAX_VALUE;
        for(int i=low; i<=high; i++){
            tmp = i+Math.max(helper(dp, low, i-1), helper(dp, i+1, high));
            res = Math.min(tmp, res);
        }
        dp[low][high] = res;
        return res;
    }
}