public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList();
        if(words==null||words.length==0){
            return res;
        }
        HashMap<String, Integer> map = new HashMap();
        int len = words.length;
        for(int i=0; i<len; i++){
            map.put(words[i], i);
        }
        
        for(int i=0; i<len; i++){
            if(isPalindrome(words[i])&&map.containsKey("")){
                    int found = map.get("");
                    if(i==found){
                        continue;
                    }
                    res.add(Arrays.asList(found, i));
                    res.add(Arrays.asList(i, found));
                    
            }
        }
        
        for(int i=0; i<len; i++){
            String rev = rev(words[i]);
            if(map.containsKey(rev)){
                int found = map.get(rev);
                if(found==i){
                    continue;
                }
                res.add(Arrays.asList(i, found));
                
            }
        }
        
        for(int i=0; i<len; i++){
            for(int j=1; j<words[i].length(); j++){
                String tmp1 = words[i].substring(0, j);
                String tmp2 = words[i].substring(j, words[i].length());
                if(map.containsKey(rev(tmp1))&&isPalindrome(tmp2)){
                    res.add(Arrays.asList(i, map.get(rev(tmp1))));
                }
                if(map.containsKey(rev(tmp2))&&isPalindrome(tmp1)){
                    res.add(Arrays.asList(map.get(rev(tmp2)), i));
                }
            }
        }
        
        
        return res;
    }
    
    private String rev(String cur){
        StringBuilder tmp = new StringBuilder(cur);
        return tmp.reverse().toString();
    }
    
    private boolean isPalindrome(String str){
        int i=0, j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}