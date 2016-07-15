public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        
        int len = Math.max(strs1.length, strs2.length);
        for(int i=0; i<len; i++){
            int i1 = i>=strs1.length?0:Integer.parseInt(strs1[i]);
            int i2 = i>=strs2.length?0:Integer.parseInt(strs2[i]);
            if(i1>i2){
                return 1;
            }else if(i1<i2){
                return -1;
            }else{
                continue;
            }
        }
        return 0;
    }
}