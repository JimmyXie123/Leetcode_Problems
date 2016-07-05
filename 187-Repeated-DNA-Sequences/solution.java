public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList();
        if(s==null){
            return res;
        }
        
        HashMap<String, Integer> map = new HashMap();
        for(int i=0; i<=s.length()-10; i++){
            String tmp = s.substring(i, i+10);
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp)+1);
            }else{
                map.put(tmp, 1);
            }
        }
        for(String str:map.keySet()){
            if(map.get(str)>1){
                res.add(str);
            }
        }
        
        return res;
    }
}