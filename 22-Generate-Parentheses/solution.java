public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        String path = "";
        helper(res, path, n, n);
        return res;
    }
    
    private void helper(List<String> res, String path, int left, int right){
        if(left==0&&right==0){
            res.add(new String(path));
        }
        
        if(right>0&&right>left){
            helper(res, path+")", left, right-1);
        }
        
        if(left>0){
            helper(res, path+"(", left-1, right);
        }
    }
}