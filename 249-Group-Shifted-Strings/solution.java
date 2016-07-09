public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap();
        List<List<String>> res = new ArrayList();
        for(String str:strings){
            String key = "";
            int offset = (int)(str.charAt(0)-'a');
            for(int i=0; i<str.length(); i++){
                char c = (char)(str.charAt(i)-offset);
                if(c<'a'){
                    c += 26;
                }
                key += c;
            }
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        for(String str:map.keySet()){
            Collections.sort(map.get(str));
            res.add(map.get(str));
        }
        return res;
    }
}