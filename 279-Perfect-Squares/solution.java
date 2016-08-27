public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        if(n==0) return 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                if(dp[i]==0&&i-j*j>=0) dp[i] = dp[i-j*j]+1;
                else if(dp[i]!=0&&i-j*j>=0) dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
            }
        }
        
        return dp[n];
    }
}