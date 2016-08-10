public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int houseCount =0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    houseCount++;
                }
            }
        }
        
        int reachCounts[][] = new int[m][n];
        int distance[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int tmp = bfs(grid, i, j, reachCounts, distance);
                    if(tmp!=houseCount)    return -1;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0&&reachCounts[i][j]==houseCount){
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res;
    }
    
    private int bfs(int[][] grid, int x, int y, int[][] reachCounts, int[][] distance){
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        int level = -1;
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(x, y));
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int j=0; j<size; j++){
                Node tmp = queue.poll();
                if(grid[tmp.x][tmp.y]==0)  distance[tmp.x][tmp.y] += level;
                for(int i=0; i<4; i++){
                    int nextX = tmp.x+dX[i];
                    int nextY = tmp.y+dY[i];
                    if(nextX<0||nextX>=m||nextY<0||nextY>=n||grid[nextX][nextY]==2||visited[nextX][nextY]){
                        continue;
                    }
                    if(grid[nextX][nextY]==1){
                        visited[nextX][nextY]=true;
                        count++;
                        continue;
                    }
                    visited[nextX][nextY]=true;
                    reachCounts[nextX][nextY]++;
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }
        return count;
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}