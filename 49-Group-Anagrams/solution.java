public class Solution {
    private boolean isAnagram(String source, String target){
        if(source.length()!=target.length()){
            return false;
        }
        int[] hash = new int[256];
        for(char ch:source.toCharArray()){
            hash[ch]++;
        }
        for(char ch:target.toCharArray()){
            hash[ch]--;
            if(hash[ch]<0){
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        List<String> path = new ArrayList();
        if(strs==null){
            return res;
        }
        int len = strs.length;
        boolean[] visited= new boolean[len];
        for(int i=0; i<len; i++){
            if(visited[i]==true){
                continue;
            }
            path.clear();
            path.add(strs[i]);
            visited[i] = true;
            for(int j=i+1; j<len; j++){
                if(isAnagram(strs[i], strs[j])){
                    path.add(strs[j]);
                    visited[j] = true;
                }
            }
            res.add(new ArrayList(path));
        }
        return res;
    }
}