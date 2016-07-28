public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k<=0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap();
        int len = s.length();
        int fast = 0, slow = 0;
        int size = 0;
        while(fast<len){
            char tmp = s.charAt(fast);
            char left = s.charAt(slow);
            if(!map.containsKey(tmp)){
                map.put(tmp, 0);
            }
            map.put(tmp, map.get(tmp)+1);
            //System.out.println("tmp="+tmp+" map.get("+tmp+")="+map.get(tmp));
            while(map.size()>k){
                //System.out.println(fast+" "+slow+" "+left+" "+map.get(left));
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