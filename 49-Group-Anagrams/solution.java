public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<char[], ArrayList<String>> map = new HashMap();
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<String>());
            }
            map.get(ch).add(str);//------------这句话必须有
            
        }
        return new ArrayList<ArrayList<String>>(map.values());
    }
}