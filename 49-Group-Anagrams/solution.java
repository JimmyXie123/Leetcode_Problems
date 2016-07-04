public class Solution {
    private boolean isAnagram(String source, String target){
        if(source.length()!=target.length()){
            return false;
        }
        HashMap<Character, Integer> toFind = new HashMap();
        HashMap<Character, Integer> Found = new HashMap();
        for(int i=0; i<source.length(); i++){
            char ch1 = source.charAt(i);
            if(toFind.containsKey(ch1)){
                toFind.put(ch1, toFind.get(ch1)+1);
            }else{
                toFind.put(ch1, 1);
            }
            char ch2 = target.charAt(i);
            if(Found.containsKey(ch2)){
                Found.put(ch2, Found.get(ch2)+1);
            }else{
                Found.put(ch2, 1);
            }
        }
        for(char ch:toFind.keySet()){
            if(!toFind.get(ch).equals(Found.get(ch))){
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