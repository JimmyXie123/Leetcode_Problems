public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits==null||digits.length()==0){
            return res;
        }
        char[] path = new char[digits.length()];
        
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        
        helper(map, res, digits, path, 0);
        return res;
        
    }
    
    private void helper(Map<Character, char[]> map, List<String> res, String digits, char[] path, int pos){
        if(path.length==pos){
            res.add(new String(path));
            return;
        }
        
        for(char ch:map.get(digits.charAt(pos))){
            path[pos] = ch;
            helper(map, res, digits, path, pos+1);
        }
    }
}