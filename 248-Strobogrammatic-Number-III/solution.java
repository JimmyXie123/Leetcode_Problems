public class Solution {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        HashMap<Character, Character> map = new HashMap();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        for(int i=low.length(); i<=high.length(); i++){
            dfs(low, high, new char[i], 0, i-1, map);
        }
        return res;
    }
    
    private void dfs(String low, String high, char c[], int left, int right, HashMap<Character, Character> map){
        if(left>right){
            String s = new String(c);
            if((s.length()==low.length()&&s.compareTo(low)<0)||(s.length()==high.length()&&s.compareTo(high)>0)){
                return;
            }
            res++;
            return;
        }
        
        for(Character ch:map.keySet()){
            if(c.length!=1&&ch=='0'&&left==0) {
                continue;
            }
            if(c.length%2==1&&left==right&&(ch=='6'||ch=='9')) continue;
            c[left] = ch;
            c[right] = map.get(ch);
            dfs(low, high, c, left+1, right-1, map);
        }
    }
}