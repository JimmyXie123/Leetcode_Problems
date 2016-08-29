public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList();
        helper(res, word.toCharArray(), 0, word);
        return res;
    }
    
    private void helper(List<String> res, char[] c, int pos, String word){
        
            String tmp ="";
            int k=0;
            int pointer = 0;
            while(k<c.length){
                if(c[k]=='1'){
                    pointer++;
                    k++;
                }else{
                    if(pointer!=0) {
                        tmp += pointer;
                        pointer = 0;
                    }
                    tmp += c[k];
                    k++;
                }
            }
            if(pointer!=0)  tmp+=pointer;
            res.add(tmp);
            
            if(pos==c.length) return;
        
            
            for(int i=pos; i<c.length; i++){
                c[i] = '1';
                helper(res, c, i+1, word);
                c[i] = word.charAt(i);
            }
        
    }
}