public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> path = new ArrayList();
        if(s==null||s.length()==0){
            return result;
        }
        
        helper(s, 0, path, result);
        return result;
    }
    
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private void helper(String s, int pos, List<String> path, List<List<String>> result){
        if(pos==s.length()){
            result.add(new ArrayList(path));
        }
        
        for(int i = pos+1; i<=s.length(); i++){
            String prefix = s.substring(pos, i);
            if(isPalindrome(prefix)){
                path.add(prefix);
                helper(s, i, path, result);
                path.remove(path.size()-1);
            }
        }
        
    }
}