public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates==null||candidates.length==0)  return res;
        List<Integer> list = new ArrayList();
        helper(res, list, candidates, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int sum, int pos){
        if(sum<0)   return;
        if(sum==0)  {
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i=pos; i<candidates.length; i++){
            list.add(candidates[i]);
            helper(res, list, candidates, sum-candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}