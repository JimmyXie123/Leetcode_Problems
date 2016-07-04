public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();  //-------cannot use array as hashmap key--------
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String tmp = new String(ch);
            if(!map.containsKey(tmp)){
                map.put(tmp, new ArrayList<String>());
            }
            map.get(tmp).add(str);//------------这句话必须有
            
        }
        return new ArrayList<List<String>>(map.values());
    }
}