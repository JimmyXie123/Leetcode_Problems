public class Solution {
    int total = 0;
    private boolean isValid(List<Integer> cols, int col){
        int row = cols.size();
        for(int i=0; i<row; i++){
            if(cols.get(i)==col){
                return false;
            }
            if(cols.get(i)+i==row+col){
                return false;
            }
            if(cols.get(i)-i==col-row){
                return false;
            }
        }
        return true;
    }
    
    private void search(List<Integer> cols, int n){
        if(cols.size()==n){
            total++;
        }
        
        for(int col=0; col<n; col++){
            if(!isValid(cols, col)){
                continue;
            }
            cols.add(col);
            search(cols, n);
            cols.remove(cols.size()-1);
        }
    }
    
    public int totalNQueens(int n) {
        if(n<=0){
            return 0;
        }
        search(new ArrayList(), n);
        return total;
    }
}