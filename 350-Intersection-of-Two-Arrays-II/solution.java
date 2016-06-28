public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for(int i:nums1){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        
        int start = 0;
        for(int i:nums2){
            if(map.containsKey(i)){
                if(map.get(i)>0){
                    nums1[start++] = i;
                    map.put(i, map.get(i)-1);
                }else{
                    map.remove(i);
                }
            }
        }
        int[] res = new int[start];
        for(int i = 0; i<res.length; i++){
            res[i] = nums1[i];
        }
        return res;
    }
}