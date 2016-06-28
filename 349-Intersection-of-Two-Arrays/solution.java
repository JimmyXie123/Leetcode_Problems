public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        for(int i:nums1){
            if(!set.contains(i)){
                set.add(i);
            }
        }
        if(nums1==null||nums2==null){
            return null;
        }
        
        int start = 0;
        for(int i:nums2){
            if(set.contains(i)){
                nums1[start++] = i;
                set.remove(i);
            }
        }
        int[] res = new int[start];
        for(int i = 0; i<res.length; i++){
            res[i] = nums1[i];
        }
        return res;
    }
}