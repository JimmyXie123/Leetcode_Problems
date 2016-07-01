public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i:nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        int res=0;
        for(int i:set){
            res = i;
        }
        return res;
    }
}