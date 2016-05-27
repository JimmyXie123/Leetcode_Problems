public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        boolean result[][] = new boolean[length1+1][length2+1];
        
        
        if(s3.length()!=length1+length2){
            return false;
        }
        
        for(int i=0; i<length1+1; i++){
            result[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for(int j=1; j<length2+1; j++){
            result[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }
        
        for(int i=1; i<length1+1; i++){
            for(int j=1; j<length2+1; j++){
                /*if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                    result[i][j] = result[i-1][j];
                    if(result[i][j]==true){
                        continue;
                    }
                }else if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                    result[i][j] = result[i][j-1];
                }*/
                result[i][j] = (result[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)))||(result[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)));
            }
        }
        
        return result[length1][length2];
        
        
    }
}