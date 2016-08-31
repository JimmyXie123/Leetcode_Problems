public class Solution {
    int total = 0;
    public int totalNQueens(int n) {
        if(n<=0)    return 0;
        List<Integer> cols = new ArrayList();
        helper(cols, n);
        return total;
    }
    
    private boolean isValid(List<Integer> cols, int curr, int n){
        int len = cols.size();
        for(int i=0; i<len; i++){
            int prev = cols.get(i);
            if(prev==curr||prev-i==curr-len||prev+i==curr+len)  return false;
        }
        return true;
    }
    
    private void helper(List<Integer> cols, int n){
        if(cols.size()==n) {
            total++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(isValid(cols, i, n)){
                cols.add(i);
                helper(cols, n);
                cols.remove(cols.size()-1);
            }   
        }
    }
}