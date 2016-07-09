public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0'); map.put('1', '1'); map.put('6','9'); 
        map.put('8','8'); map.put('9','6');
        int l = 0, r = num.length()-1;
        while (l <= r) {
            char ll = num.charAt(l), rr = num.charAt(r);
            if (! map.containsKey(ll) || rr != map.get(ll)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}