public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null){
            return false;
        }
        HashSet<Integer> dic = new HashSet();
        for(int i=0; i<nums.length; i++){
            if(dic.contains(nums[i])){
                return true;
            }else{
                dic.add(nums[i]);
            }
        }
        return false;
    }
}