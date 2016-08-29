public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList();
        StringBuilder path = new StringBuilder();
        helper(res, path, word.toCharArray(), 0, 0);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder path, char[] c, int pos, int num){
        int len = path.length();
        if(pos==c.length){
            if(num!=0)  path.append(num);
            res.add(path.toString());
        }else{
            helper(res, path, c, pos+1, num+1);
            
            if(num!=0)  path.append(num);
            helper(res, path.append(c[pos]), c, pos+1, 0);
        }
        path.setLength(len);   
        
    }
}