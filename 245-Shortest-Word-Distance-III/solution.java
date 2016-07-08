public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1=-1, p2=-1, min = Integer.MAX_VALUE;
        int prev = p2;
        for(int i=0; i<words.length; i++){
            if(!word1.equals(word2)){
                if(words[i].equals(word1)){
                    p1 = i;
                }
                if(words[i].equals(word2)){
                    p2 = i;
                }
                if(p1!=-1&&p2!=-1){
                    min = Math.min(min, Math.abs(p1-p2));
                }
            }else{
                if(words[i].equals(word1)){
                    if(p2==prev){
                        p1=i;
                    }       
                    if(p1==prev){
                        p2=i;
                    }
                    prev = i;
                    if(p1!=-1&&p2!=-1){
                        min = Math.min(min, Math.abs(p1-p2));
                    }
                }
            }
            
        }
        return min;
    }
}