public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<char[], ArrayList<String>> map = new HashMap();
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            if(!map.contains(ch)){
                map.put(ch, new ArrayList());
            }else{
                map.get(ch).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}