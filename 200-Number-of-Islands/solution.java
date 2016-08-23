class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        int number = 0;
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='0') continue;
                else{
                    number++;
                    BFS(grid, i, j);
                }
            }
        }
        
        return number;
    }
    
    private void BFS(char[][] grid, int x, int y){
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(x, y));
        grid[x][y]='0';
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = dX[i]+curr.x;
                int nextY = dY[i]+curr.y;
                if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&grid[nextX][nextY]=='1'){
                    grid[nextX][nextY] = '0';
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }
    }
}