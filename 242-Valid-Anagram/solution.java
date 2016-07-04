public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> toFind = new HashMap();
        HashMap<Character, Integer> Found = new HashMap();
        for(char ch:s.toCharArray()){
            if(toFind.containsKey(ch)){
                toFind.put(ch, toFind.get(ch)+1);
            }else{
                toFind.put(ch, 1);
            }
        }
        
        for(char ch:t.toCharArray()){
            if(Found.containsKey(ch)){
                Found.put(ch, Found.get(ch)+1);
            }else{
                Found.put(ch, 1);
            }
        }
        
        for(char ch:toFind.keySet()){
            if(!Found.containsKey(ch)){
                return false;
            }
            
            int a1 = Found.get(ch);
            int a2 = toFind.get(ch);
            if(a1!=a2){
                return false;
            }
            
        }
        return true;
    }
}