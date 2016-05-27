public class Solution {
    public int numDistinct(String s, String t) {
        if(s==null||t==null){
            return 0;
        }    
        
        int s_length = s.length();
        int t_length = t.length();
        int result[][] = new int[s_length+1][t_length+1];
        
        for(int i=0; i<s_length+1; i++){
            result[i][0] = 1;
        }
        
        for(int j=1; j<t_length+1; j++){
            result[0][j] = 0;
        }
        
        for(int i=1; i<s_length+1; i++){
            for(int j=1; j<t_length+1; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    result[i][j] = result[i-1][j-1] + result[i-1][j] ;
                }else{
                    result[i][j] = result[i-1][j];
                }
            }
        }
        
        return result[s_length][t_length];
    }
}