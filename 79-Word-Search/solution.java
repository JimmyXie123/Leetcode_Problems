public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0)    return false;
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(DFS(board, i, j, word, 0, visited))  return true;
            }
        }
        
        return false;
    }
    
    
    //--------take care of this goddamn DFS here.------------------------------
    private boolean DFS(char[][] board, int x, int y, String word, int pos, boolean[][] visited){
        if(pos==word.length())  return true;
        
        if(x<0||x>=m||y<0||y>=n)    return false;
        
        if(board[x][y]!=word.charAt(pos))   return false;
        
        if(visited[x][y])   return false;
        
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nextX = x+dX[i];
            int nextY = y+dY[i];
            if(DFS(board, nextX, nextY, word, pos+1, visited))  {
                visited[x][y] = false;
                return true;
            }
        }
        visited[x][y] = false;
        
        return false;
        
    }
}