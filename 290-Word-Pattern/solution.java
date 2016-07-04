public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Characeter, String> map = new HashMap();
        int slow = 0, fast = 0;
        for(int i=0; i<pattern.length(); i++){
            if(fast>=str.length()&&i<pattern.length()){
                return false;
            }
            while(str.charAt(fast)!=' '){
                fast++;
            }
            String tmp = str.substring(slow, fast);
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), tmp);
            }else if(map.containsKey(pattern.charAt(i))&&!map.get(pattern.charAt(i)).equals(tmp)){
                return false;
            }
            fast++;
            slow =fast;
        }
        return true;
    }
}