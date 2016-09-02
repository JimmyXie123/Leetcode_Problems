public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        helper(res, list, 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int pos, int count, int n){
        if(count==0) {
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i=pos; i<=n; i++){
            list.add(i);
            helper(res, list, i+1, count-1, n);
            list.remove(list.size()-1);
        }
    }
}