public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        if(n<=0)  return res;
        List<Integer> col = new ArrayList();
        helper(res, col, n);
        return res;
    }
    
    private void helper(List<List<String>> res, List<Integer> col, int n){
        if(col.size()==n) {
            res.add(draw(col, n));
            return;
        }
        
        for(int i=0; i<n; i++){
            if(isValid(col, i, n)){
                col.add(i);
                helper(res, col, n);
                col.remove(col.size()-1);
            }
        }
    }
    
    private boolean isValid(List<Integer> col, int curr, int n){
        int len = col.size();
        for(int i=0; i<len; i++){
            int prev = col.get(i);
            if(curr==prev) return false;
            if(curr-prev==len-i)   return false;
            if(curr+len==i+prev)    return false;
        }
        return true;
    }
    
    private List<String> draw(List<Integer> col, int n){
        List<String> res = new ArrayList();
        for(int i=0; i<n; i++){
            String tmp = "";
            int start = 0;
            int Q = col.get(i);
            while(start<n){
                if(start==Q)    tmp += "Q";
                else    tmp += ".";
                start++;
            }
            res.add(tmp);
        }
        return res;
    }
}