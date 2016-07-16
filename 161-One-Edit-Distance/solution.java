public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length())>1)
            return false;
            
        if(s.length()==t.length()){
            return isModify(s,t);
        }else if(s.length()-t.length()==1){
            return isDel(s, t);
        }else{
            return isDel(t, s);
        }
        
    }
    
    private boolean isDel(String s, String t){
        for(int i=0; i<t.length(); i++){
            if(s.charAt(i)!=t.charAt(i)){
                return s.substring(i+1, s.length()).equals(t.substring(i, t.length())); 
            }
        }
        return true;
    }
    
    private boolean isModify(String s, String t){
        int diff = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=t.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }
}