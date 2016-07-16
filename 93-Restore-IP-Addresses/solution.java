public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        List<String> list = new ArrayList();
        helper(res, list, s, 0);
        return res;
    }
    
    private void helper(List<String> res, List<String> list, String s, int start){
        if(list.size()==4){
            if(start!=s.length()){
                return;
            }
            StringBuilder tmp = new StringBuilder();
            for(String str:list){
                tmp.append(str).append(".");
            }
            tmp.deleteCharAt(tmp.length()-1);
            res.add(tmp.toString());
            return;
        }
        
        for(int i=start; i<s.length()&&i<=start+3; i++){
            String temp = s.substring(start, i+1);
            if(isValid(temp)){
                list.add(temp);
                helper(res, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isValid(String s){
        if(s.charAt(0)=='0') return s.equals("0");
        return Integer.valueOf(s)>=0&&Integer.valueOf(s)<256;
    }
}