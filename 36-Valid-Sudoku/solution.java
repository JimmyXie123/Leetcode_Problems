public class Solution {
    int[] dX = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] dY = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
    
        //every row
        for(int i=0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j=0; j<9; j++){
                if(!process(visited, board, i, j)){
                    return false;
                }
            }
        }
        
        //every col
        for(int i=0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j=0; j<9; j++){
                if(!process(visited, board, j, i)){
                    return false;
                }
            }
        }
        
        System.out.println("123");
        //subgrid
        for(int i=0; i<9; i=i+3){
            Arrays.fill(visited, false);
            for(int j=0; j<9; j=j+3){
                
                    if(!process(visited, board, i + w/3, j + w%3))
                        return false;        
                    
            }
        }
        
        return true;
    
    }
    
    private boolean process(boolean[] visited, char[][] board, int i, int j){
        if(board[i][j]=='.'){
            return true;
        }
        int tmp =board[i][j]-'0';
        if(tmp<=0||tmp>=10||visited[tmp-1]){
            return false;
        }
        visited[tmp-1] = true; 
        return true;
    }
}