public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        helper(res, path, n, 2);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, int cur, int pos){
        if(cur==1&&path.size()>1){     //--------------path.size()>1和下面的i<=cur配合--------------
            res.add(new ArrayList(path));
            return;
        }
        for(int i=pos; i<=cur; i++){   //--------------必须是i<=cur-----------------
            if(cur%i==0){
                path.add(i);
                helper(res, path, cur/i, i);  //------------最后那个是i----------------
                path.remove(path.size()-1);
            }
        }
    }
}