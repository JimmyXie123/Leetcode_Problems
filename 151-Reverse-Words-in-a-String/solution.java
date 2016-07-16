public class Solution {
    public String reverseWords(String s) {
        if(s==null){
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();   //---------think about y this should use stringbuilder---------
        
        for(int i=strs.length-1; i>=0; i--){
            if(strs[i].equals("")){
                continue;
            }
            res.append(strs[i]).append(" ");
        }
        
        String ans = res.toString();
        return ans.length()==0?"":ans.substring(0, ans.length()-1);
        
        
    }
}