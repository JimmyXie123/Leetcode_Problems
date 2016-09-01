public class Solution {
    public void solveSudoku(char[][] board) {
        boolean tmp = helper(board);
    }
    
    private boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(helper(board))   return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char curr){
        for(int k=0; k<9; k++){
            if(board[i][k]==curr||board[k][j]==curr)  return false;
        }
        
        int rowstart = i/3*3;
        int colstart = j/3*3;
        for(int k=0; k<9; k++){
            if(board[rowstart+k/3][colstart+k%3]==curr)  return false;
        }
        return true;
    }
}