public class Solution {
    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, 1, -1, 0};
    private void removeIsland(char[][] grid, int x, int y){
        grid[x][y]=='0';
        for(int i=0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX>=0&&nextX<grid[0].length&&nextY>=0&&nextY<grid.length){
                if(grid[nextX][nextY]=='1'){
                    removeIsland(grid, nextX, nextY);
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int m = grid.length;
        if(grid[0].length==0){
            return 0;
        }
        int n = grid[0].length;
        
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    removeIsland(grid, i, j);
                }
            }
        }
        
        return count;
        
    }
}