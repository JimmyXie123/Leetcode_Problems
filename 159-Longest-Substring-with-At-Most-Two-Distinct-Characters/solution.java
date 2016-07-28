public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int fast = 0, slow = 0;
        int size = 0;
        while(fast<s.length()){
            char tmp = s.charAt(fast);
            char left = s.charAt(slow);
            if(!map.containsKey(tmp)){
                map.put(tmp, 0);
            }
            map.put(tmp, map.get(tmp)+1);
            while(map.size()>2){
                map.put(left, map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                slow++;
                left = s.charAt(slow);
            }
            size = Math.max(size, fast-slow+1);
            fast++;
        }
        return size;
    }
}