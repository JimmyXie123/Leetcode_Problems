public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int cache[][] = new int[m][n];
        
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                max = Math.max(dfs(matrix, i, j, cache), max);
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int x, int y, int[][] cache){
        if(cache[x][y]!=0)  return cache[x][y];
        int max = 1;
        for(int i=0; i<4; i++){
            int nextX = x+dX[i];
            int nextY = y+dY[i];
            if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && matrix[x][y]<matrix[nextX][nextY]){
                max = Math.max(dfs(matrix, nextX, nextY, cache)+1, max);
            }
        }
        cache[x][y] = max;
        return max;
    }
}

