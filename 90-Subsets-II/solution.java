public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        if(nums==null||nums.length==0)  return res;
        Arrays.sort(nums);
        helper(res, path, 0, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, int pos, int[] nums){
        res.add(new ArrayList(path));
        if(pos == nums.length)  return;
        
        for(int i=pos; i<nums.length; i++){
            if(i!=pos&&nums[i]==nums[i-1])  continue;
            path.add(nums[i]);
            helper(res, path, i+1, nums);
            path.remove(path.size()-1);
        }
    }
}