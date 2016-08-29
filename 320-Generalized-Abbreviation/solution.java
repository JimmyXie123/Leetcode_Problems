public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList();
        helper(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, char[] c, int pos, int num){
        int len = sb.length();
        if(pos==c.length) {
            if(num!=0)  sb.append(num);
            res.add(sb.toString());
        }else {
            helper(res, sb, c, pos+1, num+1);
            
            if(num!=0)  sb.append(num);
            helper(res, sb.append(c[pos]), c, pos+1, 0);       
        }
        sb.setLength(len);
    }
}