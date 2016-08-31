public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            HashSet<Character> rows = new HashSet();
            HashSet<Character> columns = new HashSet();
            HashSet<Character> grid = new HashSet();
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'&&!rows.add(board[i][j]))   return false;
                if(board[j][i]!='.'&&!columns.add(board[j][i]))   return false;
                int rowstart = i/3;
                int colstart = i%3;
                int rowindex = j/3;
                int colindex = j%3;
                if(board[rowstart*3+rowindex][3*colstart+colindex]!='.'&&!grid.add(board[rowstart*3+rowindex][3*colstart+colindex]))    return false;
                
            }
        }
        return true;
    }
}