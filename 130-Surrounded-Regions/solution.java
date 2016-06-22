public class Solution {
    int[] dX = {-1, 0, 0, 1};
    int[] dY = {0, -1, 1, 0};
    int m, n;
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        m = board.length;
        
        if(board[0]==null||board[0].length==0){
            return;
        }
        n = board[0].length;
        
        char[][] temp = new char[m+2][n+2];
        
        for(int i=0; i<m+2; i++){
            for(int j=0; j<n+2; j++){
                if(i==0||j==0||i==m+1||j==n+1){
                    temp[i][j] = '5';
                }else{
                    temp[i][j] = board[i-1][j-1];
                }
            }
        }
        
        for(int i=0; i<m+2; i++){
            for(int j=0; j<n+2; j++){
               b5(board, i, j);
            }
        }
        
        for(int i=0; i<m+2; i++){
            for(int j=0; j<n+2; j++){
                remove(board, i, j);
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(temp[i+1][j+1]=='5'){
                    board[i][j]='0';
                }else{
                    board[i][j] = temp[i+1][j+1];
                }
            }
        }
        
    }
    
    private void b5(char[][] board, int i, int j){
        if(board[i][j]!='5'){
            return;
        }
        for(int k=0; k<4; k++){
            int nextX = i+dX[k];
            int nextY = j+dX[k];
            if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n){
                if(board[nextX][nextY]=='0'){
                    board[i][j] = '5';
                }
            }
        }
    }
    
    private void remove(char[][] board, int i, int j){
        if(board[i][j]!='0'){
            return;
        }
        board[i][j] = 'X';
        for(int k=0; k<4; k++){
            int nextX = i+dX[k];
            int nextY = j+dY[k];
            if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n){
                remove(board, nextX, nextY);
            }
        }
        
    }
    
}