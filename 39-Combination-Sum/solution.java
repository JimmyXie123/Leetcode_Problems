public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        if(candidates==null){
            return result;
        }
        List<Integer> path = new ArrayList();
        helper(candidates, 0, target, result, path);
        return result;
    }
    
    private void helper(int[] candidates, int pos, int sum, List<List<Integer>> result, List<Integer> path){
        if(sum<0){
            return;
        }
        if(sum==0){
            result.add(new ArrayList(path));
        }
        
        for(int i=pos; i<candidates.length; i++){
            if(i!=0&&candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, i, sum-candidates[i], result, path);
            path.remove(path.size()-1);
        }
        
    }
}