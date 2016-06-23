public class Solution {
    private List<String> draw(List<Integer> cols){
        List<String> row = new ArrayList();
        for(int i=0; i<cols.size(); i++){
            String s = new String();
            for(int j=0; j<cols.size(); j++){
                if(j==cols.get(i)){
                    s += "Q";
                }else{
                    s += ".";
                }
            }
            row.add(s);
        }
        return row;
    }
    
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
    
    private void search(List<List<String>> result, List<Integer> cols, int n){
        if(cols.size()==n){
            result.add(draw(cols));
        }
        
        for(int col=0; col<n; col++){
            if(!isValid(cols, col)){
                continue;
            }
            cols.add(col);
            search(result, cols, n);
            cols.remove(cols.size()-1);
        }
    }
    
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList();
        if(n<=0){
            return 0;
        }
        search(result, new ArrayList(), n);
        return result.size();
    }
}