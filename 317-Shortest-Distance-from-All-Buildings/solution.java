public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public int shortestDistance(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)  return 0;
        m = grid.length;
        n = grid[0].length;
        int houseCount = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)   houseCount++; 
            }
        }
        
        
        boolean flag = false;
        int res=Integer.MAX_VALUE;
        int[][] reachCount = new int[m][n];
        int[][] distance = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    bfs(grid, i, j, reachCount, distance, houseCount);
                }
            }
        }
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(reachCount[i][j]==houseCount){
                    flag = true;
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        
        if(flag) return res;
        else return -1;
    }
    
    private void bfs(int[][] grid, int x, int y, int[][] reachCount, int[][] distance, int houseCount){
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList();
        queue.offer(getNum(x, y));
        int level = 0;
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++){
                int curr = queue.poll();
                int curr_x = curr/n;
                int curr_y = curr%n;
                //System.out.println(curr_x+" "+curr_y);
                for(int k=0; k<4; k++){
                    int nextX = dX[k]+curr_x;
                    int nextY = dY[k]+curr_y;
                    if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&!visited[nextX][nextY]&&grid[nextX][nextY]==0){
                        reachCount[nextX][nextY]++;
                        distance[nextX][nextY] += level;
                        
                        visited[nextX][nextY] = true;   //------------是个大坑-------------------
                        queue.offer(getNum(nextX, nextY));
                    }
                }
            }
        }
    }
    
    private int getNum(int x, int y){
        return x*n+y;
    }
}