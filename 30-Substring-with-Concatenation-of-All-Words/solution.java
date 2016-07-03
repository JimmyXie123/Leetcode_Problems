public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        int m = words.length;
        int n = words[0].length();
        if(m*n>s.length()){
            return res;
        }
        HashMap<String, Integer> toFind = new HashMap();
        HashMap<String, Integer> Found = new HashMap();
        
        for(String word:words){
            if(toFind.containsKey(word)){
                toFind.put(word, toFind.get(word)+1);
            }else{
                toFind.put(word, 1);
            }
        }
        
        for(int i=0; i<=s.length()-m*n; i++){
            Found.clear();
            int j=0;
            for(j=0; j<m; j++){
                int k = i+j*n;
                String temp = s.substring(k, k+n);
                if(!toFind.containsKey(temp)){
                    break;
                }
                if(Found.containsKey(temp)){
                    Found.put(temp, Found.get(temp)+1);
                }else{
                    Found.put(temp, 1);
                }
                if(Found.get(temp)>toFind.get(temp)){
                    break;
                }
            }
            if(j==m) res.add(i);
        }
        
        return res;
        
    }
}