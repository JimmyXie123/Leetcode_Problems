public class Solution {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        int count = 0;
        String mid = "";
        List<Character> list = new ArrayList();
        for(Character c:map.keySet()){
            if(map.get(c)%2==1){
                count++;
                mid += c;
                if(count>1){
                    return new ArrayList();
                }
            }
            for(int i=1; i<=map.get(c)/2; i++){
                list.add(c);
            }
        }
        
        boolean[] vis = new boolean[list.size()];
        List<String> res = new ArrayList();
        StringBuilder path = new StringBuilder();
        helper(list, res, path, mid, vis);
        return res;

    }
    
    private void helper(List<Character> list, List<String> res, StringBuilder path, String mid, boolean[] vis){
        if(list.size()==path.length()){
            res.add(path.toString()+mid+path.reverse().toString());
            path.reverse();
            return;
        }
        
        for(int i=0; i<list.size(); i++){
            if(vis[i]==true|| (i>0&& list.get(i).equals(list.get(i-1)) &&vis[i-1]==false) ){
                continue;
            }
            vis[i] = true;
            path.append(list.get(i));
            helper(list, res, path, mid, vis);
            path.deleteCharAt(path.length()-1);
            vis[i] = false;
            
        }
    }
}