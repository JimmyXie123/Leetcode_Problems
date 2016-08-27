public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public static final char BOARDER = 'B';
    public static final char REMOVE = 'X';
    
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)    return;
        m=board.length;
        n=board[0].length;
        
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                bfs(board, i, 0, BOARDER, 'O');
            }
            
            if(board[i][n-1]=='O'){
                bfs(board, i, n-1, BOARDER, 'O');
            }
        }
        
        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                bfs(board, 0, j, BOARDER, 'O');
            }
            
            if(board[m-1][j]=='O'){
                bfs(board, m-1, j, BOARDER, 'O');
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    bfs(board, i, j, REMOVE, 'O');
                }
            }
        }
        
        for(int i=0; i<m; i++){
            if(board[i][0]==BOARDER){
                bfs(board, i, 0, 'O', BOARDER);
            }
            
            if(board[i][n-1]==BOARDER){
                bfs(board, i, n-1, 'O', BOARDER);
            }
        }
        
        for(int j=0; j<n; j++){
            if(board[0][j]==BOARDER){
                bfs(board, 0, j, 'O', BOARDER);
            }
            
            if(board[m-1][j]==BOARDER){
                bfs(board, m-1, j, 'O', BOARDER);
            }
        }
    }
    
    private void bfs(char[][] board, int x, int y, char sign, char original){
        board[x][y] = sign;
        Queue<Integer> queue = new LinkedList();
        queue.offer(x*n+y);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            int curr_x = curr/n;
            int curr_y = curr%n;
            for(int i=0; i<4; i++){
                int nextX = curr_x+dX[i];
                int nextY = curr_y+dY[i];
                if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&board[nextX][nextY]==original){
                    board[nextX][nextY] = sign;
                    queue.offer(nextX*n+nextY);
                }
            }
        }
    }
}