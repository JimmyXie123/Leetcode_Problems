public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> toFind = new HashMap();
        HashMap<Character, Integer> Found = new HashMap();
        for(char ch:s.toCharArray()){
            if(toFind.contains(ch)){
                toFind.put(ch, toFind.get(ch)+1);
            }else{
                toFInd.put(ch, 1);
            }
        }
        
        for(char ch:t.toCharArray()){
            if(Found.contains(ch)){
                Found.put(ch, toFind.get(ch)+1);
            }else{
                Found.put(ch, 1);
            }
        }
        
        for(char ch:toFind.keySet()){
            if(!Found.containsKey(ch)||Found.get(ch)!=toFind.get(ch)){
                return false;
            }
        }
        return true;
    }
}