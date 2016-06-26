public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        if(n<=0||k<=0){
            return res;
        }
        List<Integer> path = new ArrayList();
        dfs(1, k, 0, n, res, path);
        return res;
    }
    
    private void dfs(int pos, int k, int sum, int n, List<List<Integer>> res, List<Integer> path){
        if(sum>n||k<0){
            return;
        }
        if(sum==n&&k==0){
          res.add(new ArrayList(path));
          return;
        }
        for(int i=pos; i<=9; i++){
            path.add(i);
            dfs(i+1, k-1, sum+i, n, res, path);
            path.remove(path.size()-1);
        }
    }
}