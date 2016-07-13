public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows==1||s.length()<numRows){
            return s;
        }
        int step = 2*(numRows-1);
        char[] res = new char[len];
        int count = 0;
        for(int i=0; i<numRows; i++){
            int interval = step-2*i;
            for(int j=i; j<len; j=j+step){
                res[count++] = s.charAt(j);
                if(interval<step&&interval>0&&count<len&&j+interval<len){
                    res[count++] = s.charAt(j+interval);
                }
            }
        }
        return new String(res);
    }
}