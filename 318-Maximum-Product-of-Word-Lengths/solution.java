public class Solution {
    public int maxProduct(String[] words) {
        if(words==null||words.length<=1){
            return 0;
        }
        int len = words.length;
        int value[] = new int[len];
        for(int i=0; i<len; i++){
            for(int j=0; j<words[i].length(); j++){
                value[i] |= 1<<((words[i].charAt(j))-'a');
            }
        }
        int res = 0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if((value[i]&value[j])==0){
                    res = Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}