public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)   return 0;
        m= grid.length;
        n= grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    removeIslands(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void removeIslands(char[][] grid, int x, int y){
        grid[x][y]='0';
        for(int i=0; i<4; i++){
            int nextX = x+dX[i];
            int nextY = y+dY[i];
            if(nextX>=0 && nextX<m && nextY>=0&& nextY<n){
                if(grid[nextX][nextY]=='1'){
                    removeIslands(grid, nextX, nextY);
                }
            }
        }
    }
}