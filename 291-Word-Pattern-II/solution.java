public class Solution {
    HashMap<Character, String> map = new HashMap();
    HashSet<String> set = new HashSet();
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length()==0) return str.length()==0;
        if(map.containsKey(pattern.charAt(0))){
            String value = map.get(pattern.charAt(0));
            if((value.length()>str.length())||(!value.equals(str.substring(0, value.length())))) return false;
            if(wordPatternMatch(pattern.substring(1), str.substring(value.length()))) return true;
        }else{
            for(int i=1; i<=str.length(); i++){   //-------i start from 1---------
                if(set.contains(str.substring(0, i))) continue;
                map.put(pattern.charAt(0),str.substring(0, i));
                set.add(str.substring(0, i));
                if(wordPatternMatch(pattern.substring(1), str.substring(i))) return true;
                set.remove(str.substring(0, i));
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}