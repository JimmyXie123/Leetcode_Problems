public class Solution {
    public int MinDistance(string word1, string word2) {
        if(word1==null&&word2==null){
            return 0;
        }
        
        if(word1==null&&word2!=null){
            return word2.length();
        }
        
        if(word2==null&&word1!=null){
            return word1.length();
        }
        
        int length1 = word1.length();
        int length2 = word2.length();
        int result[][] = new int[length1+1][length2+1];
        
        
        for(int i=0; i<length1+1; i++){
            result[i][0] = i;
        }
        
        for(int j=0; j<length2+1; j++){
            result[0][j] = j;
        }
        
        for(int i=1; i<length1+1; i++){
            for(int j=1; j<length2+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    result[i][j] = Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1), result[i-1][j-1]);
                }else{
                    result[i][j] = Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1), result[i-1][j-1]+1);
                }
            }
        }
        
        return result[length1][length2];
    }
}