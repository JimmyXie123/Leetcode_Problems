public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet();
        for(int i=0; i<nums.length; i++){
            Integer floor = set.floor(nums[i]+t);
            Integer ceil = set.ceiling(nums[i]-t);
            if((floor!=null&&floor>=nums[i])||(ceil!=null&&ceil<=nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}