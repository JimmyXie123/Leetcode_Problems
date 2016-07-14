public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList();
        if(s==null||s.length()<=1){
            return res;
        }
        
        char[] tmp = s.toCharArray();
        for(int i=1; i<s.length(); i++){
            if(tmp[i-1] == '+'&&tmp[i]== '+'){
                tmp[i-1] = tmp[i] = '-';
                res.add(new String(tmp));
                tmp[i-1] = tmp[i] ='+';
            }
        }
        return res;
    }
}