public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int[][][] visited=new int[s1.length()][s1.length()][s1.length()+1];
        return checkScramble(s1, 0, s2, 0, s1.length(), visited);
    }
    
    public boolean checkScramble(String s1, int start1, String s2, int start2, int k, int[][][] visited) {
        if(visited[start1][start2][k]==1){
            return true;
        }
        
        if(visited[start1][start2][k]==-1){
            return false;
        }
        
        if(s1.length()==0||s1.equals(s2)){
            visited[start1][start2][k] = 1;
            return true;
        }
        
        if(!isValid(s1, s2)){
            visited[start1][start2][k] = -1;
            return false;
        }
        
        for(int i=1; i<s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            
            String s23 = s2.substring(0, s2.length()-i);
            String s24 = s2.substring(s2.length()-i, s2.length());
            
            if(checkScramble(s11, start1, s21, start2, i, visited)&&checkScramble(s12, start1+i, s22, start2+i, s1.length()-i, visited)) {
                visited[start1][start2][k] = 1;
                return true;
            }
            if(checkScramble(s11, start1, s24, start2+s1.length()-i, i, visited)&&checkScramble(s12, start1+i, s23, start2, s1.length()-i, visited)) {
                visited[start1][start2][k] = 1;
                return true;
            }
        }
        visited[start1][start2][k] = -1;
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