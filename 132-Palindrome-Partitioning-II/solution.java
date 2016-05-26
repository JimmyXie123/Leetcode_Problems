public class Solution {
    private boolean[][] isPalindrome(String s){
        boolean isPalindrome[][] = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            isPalindrome[i][i] = true;
        }
        
        for(int i=0; i<s.length()-1; i++){
            isPalindrome[i][i+1] = (s.charAt(i)==s.charAt(i+1));
        }
        
        for(int length=2; length<s.length(); length++){
            for(int i=0; i+length<s.length(); i++){
               isPalindrome[i][i+length] = isPalindrome[i+1][i+length-1]&&(s.charAt(i)==s.charAt(i+length)); 
            }
        }
        
        return isPalindrome;
    }
  
    public int minCut(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        
        boolean test[][] = isPalindrome(s);
        
        int f[] = new int[s.length()+1];
        f[0] = 0;
        for(int i=1; i<f.length; i++){
            f[i] = i-1;
        }
        
        //int best = Integer.MAX_VALUE;
        for(int i=1; i<=f.length; i++){
            for(int j=0; j<i; j++){
                if(test[j][i-1]){
                    f[i] = Math.min(f[i], f[j]+1);
                }
            }
        }
        
        return f[s.length()];
        
        
    }
}