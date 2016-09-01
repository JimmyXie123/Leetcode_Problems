public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums==null||nums.length==0)  return res;
        List<Integer> path = new ArrayList();
        helper(res, path, 0, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, int pos, int[] nums){
        res.add(new ArrayList(path));
        if(pos==nums.length){
            return;
        }
        
        for(int i=pos; i<nums.length; i++){
            path.add(nums[i]);
            helper(res, path, i+1, nums);
            path.remove(path.size()-1);
        }
    }
}