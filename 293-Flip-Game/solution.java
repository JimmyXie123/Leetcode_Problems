public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList();
        char[] tmp = s.toCharArray();
        int len = s.length();
        for(int i=0; i<len-1; i++){
            if(tmp[i]=='+'&&tmp[i+1]=='+') {
                tmp[i] = '-';
                tmp[i+1] = '-';
                res.add(new String(tmp));
                tmp[i] = '+';
                tmp[i+1] = '+';
            }
        }
        
        return res;
    }
}