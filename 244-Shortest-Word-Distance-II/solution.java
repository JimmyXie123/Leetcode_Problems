public class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                map.put(words[i], new ArrayList());
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min =Integer.MAX_VALUE;
        for(int i1:map.get(word1)){
            for(int i2:map.get(word2)){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");