public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(char ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }
        int num = 0;
        for(Character ch:map.keySet()){
            if(map.get(ch)%2==1){
                num++;
            }
        }
        if(num>=2){
            return false;
        }else if(num==1){
            return s.length()%2==1;
        }else{
            return true;
        }
    }
}