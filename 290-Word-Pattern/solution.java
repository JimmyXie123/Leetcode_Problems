public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap();
        HashMap<String, Character> map1 = new HashMap();
        int slow = 0, fast = 0;
        for(int i=0; i<pattern.length(); i++){
            if(fast>=str.length()){
                return false;
            }
            while(fast<str.length()&&str.charAt(fast)!=' '){
                fast++;
            }
            String tmp = str.substring(slow, fast);
            //System.out.println(tmp);
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), tmp);
            }else if(map.containsKey(pattern.charAt(i))&&!map.get(pattern.charAt(i)).equals(tmp)){
                return false;
            }
            
            if(!map1.containsKey(tmp)){
                map1.put(tmp, pattern.charAt(i));
            }else if(map1.containsKey(tmp)&&!map1.get(tmp).equals(pattern.charAt(i))){
                return false;
            }
            
            fast++;
            slow =fast;
        }
        if(fast<str.length()){
            return false;
        }
        return true;
    }
}