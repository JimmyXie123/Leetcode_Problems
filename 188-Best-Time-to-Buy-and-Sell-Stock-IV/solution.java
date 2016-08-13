public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k==0){
            return 0;
        }
        
        int res = 0;
        int n = prices.length;
        if(k>=prices.length/2){
            for(int i=1; i<prices.length; i++){
                if(prices[i]>prices[i-1]){
                    res += prices[i]-prices[i-1];
                }
            }
            return res;
        }
        
        int[][] mustsell = new int[n+1][k+1];    //--------必须sell---------
        int[][] nosell = new int[n+1][k+1];     //--------可以不sell-----------
        
        for(int i=0; i<=k; i++){
            mustsell[0][i] = nosell[0][i] = 0;
        }
        
        for(int i=1; i<n; i++){
            mustsell[i][0] = 0;
            int gainorlose = prices[i]-prices[i-1];
            for(int j=1; j<=k; j++){
                mustsell[i][j] = gainorlose + Math.max(mustsell[i-1][j], nosell[i-1][j-1]);  
                //-----take care of these tricky relations
                nosell[i][j] = Math.max(mustsell[i][j], nosell[i-1][j]);
            }
        }
        
        return nosell[n-1][k];
        
    }
}