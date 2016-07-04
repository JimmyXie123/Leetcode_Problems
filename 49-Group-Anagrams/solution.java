public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String tmp = new String(ch);
            if(!map.contains(tmp)){
                map.put(ch, new ArrayList());
            }else{
                map.get(tmp).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}