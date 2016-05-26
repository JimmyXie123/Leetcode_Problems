public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean f[] = new boolean[s.length()+1];
        f[0] = true;
        for(int i=1; i<f.length; i++){
            f[i] = false;
        }
        
        for(int i=1; i<f.length; i++){
            for(int j=0; j<i; j++){
                if(f[j]==true||wordDict.contains(s.subString(j, i-1))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}