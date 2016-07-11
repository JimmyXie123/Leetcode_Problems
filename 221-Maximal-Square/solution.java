public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null){
            return 0;
        }
        int m = matrix.length;
        if(matrix.length==0||matrix[0]==null||matrix[0].length==0){
            return 0;
        }
        int n = matrix[0].length;
        
        int res[][] = new int[m][n];
        int ans = 0;
        for(int i=0; i<m; i++){
            res[i][0] = matrix[i][0]-48;
            ans = Math.max(ans, res[i][0]);
            for(int j=1; j<n; j++){
                if(i==0){
                    res[i][j] = matrix[i][j]-48;
                }else{
                    if(matrix[i][j]=='1'){
                        res[i][j] = Math.min(res[i-1][j], Math.min(res[i][j-1], res[i-1][j-1]))+1;
                    }else{
                        res[i][j] = 0;
                    }
                }
                ans = Math.max(ans, res[i][j]);
            }
        }
        return ans*ans;
    }
}