public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict==null||wordDict.isEmpty()){
            return false;
        }
        boolean f[] = new boolean[s.length()+1];
        f[0] = true;
        for(int i=1; i<f.length; i++){
            f[i] = false;
        }
        
        for(int i=1; i<f.length; i++){
            for(int j=0; j<i; j++){
                if(f[j]==true&&wordDict.contains(s.substring(j, i-1))){
                    f[i] = true;
                    break;
                }
               
            }
        }
        
        System.out.println(f[4]);
        
        return f[s.length()];
    }
}