public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates==null) return res;
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        helper(res, list, candidates, 0, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int pos, int sum){
        if(sum<0)   return;
        if(sum==0) {
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i=pos; i<candidates.length; i++) {
            if(i!=pos&&candidates[i]==candidates[i-1])  continue;
            list.add(candidates[i]);
            helper(res, list, candidates, i+1, sum-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}