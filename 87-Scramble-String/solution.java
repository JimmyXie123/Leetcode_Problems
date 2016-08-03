public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        
        if(s1.length()==0||s1.equals(s2)){
            return true;
        }
        
        if(!isValid(s1, s2)){
            return false;
        }
        
        for(int i=1; i<s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            
            String s23 = s2.substring(0, s2.length()-i);
            String s24 = s2.substring(s2.length()-i, s2.length());
            
            if(isScramble(s11, s21)&&isScramble(s12, s22)) return true;
            if(isScramble(s11, s24)&&isScramble(s12, s23)) return true;
        }
        return false;
    }
    
    private boolean isValid(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String s11 = new String(ch1);
        String s22 = new String(ch2);
        if(s11.length()==0||s11.equals(s22)){
            return true;
        }else{
            return false;
        }
    }
}