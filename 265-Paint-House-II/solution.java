public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null||costs.length==0||costs[0].length==0){
            return 0;
        }
        int n=costs.length;
        int k=costs[0].length;
        
        int[][] dp = new int[n][k];
        int min1 = Integer.MAX_VALUE;
        int index1 = 0;
        int min2 = Integer.MAX_VALUE;
        int index2 = 0;
        for(int j=0; j<k; j++){
            dp[0][j] = costs[0][j];
            if(dp[0][j]<min1){
                min2 = min1;
                min1 = dp[0][j];
                index2 = index1;
                index1 = j;
            }else if(dp[0][j]<min2){
                min2 = dp[0][j];
                index2 = j;
            }
        }
            
    
        for(int i=1; i<n; i++){
            //System.out.println(min1+" "+min2);
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            int tmp1 = 0;
            int tmp2 = 0;
            for(int j=0; j<k; j++){
                if(j!=index1){
                    dp[i][j] = costs[i][j]+dp[i-1][index1];
                }else{
                    dp[i][j] = costs[i][j]+dp[i-1][index2];
                }
                
                if(dp[i][j]<min1){
                    min2 = min1;
                    min1 = dp[i][j];
                    tmp2 = tmp1;
                    tmp1 = j;
                }else if(dp[i][j]<min2){
                    min2 = dp[i][j];
                    tmp2 = j;
                }
            }
            index1 = tmp1;
            index2 = tmp2;
        }
        
        return dp[n-1][index1];
    }
}