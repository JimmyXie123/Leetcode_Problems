public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        DFS(res, path, 1, n, k);
        return res;
    }
    
    private void DFS(List<List<Integer>> res, List<Integer> path, int pos, int n, int k){
        if(path.size()==k){
            List<Integer> tmp = new ArrayList(path);
            Collections.sort(tmp);
            res.add(tmp);
            return;
        }
        
        for(int i=pos; i<=n; i++){
                path.add(i);
                DFS(res, path, i+1, n, k);
                path.remove(path.size()-1);
        }
    }
}