public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        helper(res, path, n, 2);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, int cur, int pos){
        if(cur==1&&path.size()>1){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=pos; i<=cur; i++){
            if(cur%i==0){
                path.add(i);
                helper(res, path, cur/i, i);
                path.remove(path.size()-1);
            }
        }
    }
}