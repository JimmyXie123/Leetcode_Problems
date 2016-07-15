public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        String[] strs = s.split(" ");
        if(strs==null||strs.length==0){
            return 0;
        }
        if(strs[strs.length-1]==null){
            return 0;
        }
        return strs[strs.length-1].length();
    }
}