public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String tmp = new String(ch);
            if(!map.containsKey(temp)){
                map.put(ch, new ArrayList<String>());
            }
            map.get(ch).add(tmp);//------------这句话必须有
            
        }
        return new ArrayList<List<String>>(map.values());
    }
}