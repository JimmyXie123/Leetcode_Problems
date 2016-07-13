public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if(strs==null||strs.length==0){
            return "";
        }
        
        
        int short_len = Integer.MAX_VALUE;
        for(String str:strs){
            short_len = Math.min(short_len, str.length());
        }
        
        for(int i=0; i<short_len; i++){
            if(!check(strs, i)){
                return new String(res);
            }else{
                res.append(strs[0].charAt(i));
            }
        }
        return res.toString();
    }
    
    private boolean check(String[] strs, int index){
        for(int i=1; i<strs.length; i++){
            if(strs[i].charAt(index)!=strs[i-1].charAt(index)){
                return false;
            }
        }
        return true;
    }
}