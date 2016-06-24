public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        if(candidates==null){
            return result;
        }
        List<Integer> path = new ArrayList();
        dfs(result, path, 0, target, nums);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int pos, int sum, int[] nums){
        if(sum<0){
            return;
        }
        if(sum==0){
            result.add(new ArrayList(path));
        }
        for(int i=pos+1; i<nums.length; i++){
            if(i!=pos+1&&nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(result, path, i, sum-nums[pos], nums);
            path.remove(path.size()-1);
        }
    }
}