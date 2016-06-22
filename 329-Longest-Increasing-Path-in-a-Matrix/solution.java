public class Solution {
    private int[] dX={-1, 0, 0, 1};
    private int[] dY={0, -1, 1, 0};
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        m = matrix.length;
        if(matrix[0].length==0){
            return 0;
        }
        n = matrix[0].length;
        
        int[][] cache = new int[m][n]; 
        int max = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(dfs(matrix, i, j), max);
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j){
        if(cache[i][j]!=0) return cache[i][j]; 
        int max = 1;
        for(int k=0; k<4; k++){
            int nextX = i+dX[k];
            int nextY = j+dY[k];
            if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && matrix[i][j]<matrix[nextX][nextY]){
                max = Math.max(max, 1+dfs(matrix, nextX, nextY));
            }
        }
        cache[i][j] = max;
        return max;
    }
}