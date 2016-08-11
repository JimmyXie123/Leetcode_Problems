public class Solution {
    private List<String> helper(String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if(map.containsKey(s))  return map.get(s);
        ArrayList<String> res = new ArrayList();
        if(s.length()==0)  {
            return res;
        }
        for(int i=1; i<=s.length(); i++){
            String value = s.substring(0, i);
            if(wordDict.contains(value)){
                if(i==s.length()){
                    res.add(value);
                }else{
                    List<String> tmp = helper(s.substring(i), wordDict, map);
                    //------if tmp is null, this loop will never be executed, so invalid results will be ruled out
                    for(String str:tmp){
                        String path = value+" "+str;
                        res.add(path);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        return helper(s, wordDict, map);
    }
}
