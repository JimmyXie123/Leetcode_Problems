public class ValidWordAbbr {
    HashMap<String, String> map = new HashMap();
    public ValidWordAbbr(String[] dictionary) {
        for(String word:dictionary){
            int count = 0;
            for(int i=1; i<word.length()-1; i++){
                count++;
            }
            
            String ele;
            if(word.length()<=1){
                ele = word;
            }else{
                ele = ""+word.charAt(0)+count+word.charAt(word.length()-1);
            }
            
            if(!map.containsKey(ele)){
                map.put(ele, word);
            }else if(!map.get(ele).equals(word)){
                map.put(ele, "");
            }
        }
    }

    public boolean isUnique(String word) {
        int count = 0;
        for(int i=1; i<word.length()-1; i++){
            count++;
        }
        
        String ele;
        if(word.length()<=1){
            ele = word;
        }else{
            ele = ""+word.charAt(0)+count+word.charAt(word.length()-1);
        }
        
        return (!map.containsKey(ele)||map.get(ele).equals(word));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");