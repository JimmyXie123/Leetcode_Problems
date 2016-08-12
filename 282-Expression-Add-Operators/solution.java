public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList();
        helper(num, "", 0, 0, 0, target, res);
        return res;
    }
    
    private void helper(String num, String path, int pos, long eval, long mult, int target, List<String> res){
        if(pos==num.length()){
            if(target==eval){
                res.add(path);
            }
        }
        
        for(int i=pos; i<num.length(); i++){
            if(i!=pos&&num.charAt(pos)=='0')    break;
            long cur = Long.parseLong(num.substring(pos, i+1));
            if(pos==0){
                helper(num, path+cur, i+1, cur, cur, target, res);
            }else{
                helper(num, path+"+"+cur, i+1, eval+cur, cur, target, res);
                helper(num, path+"-"+cur, i+1, eval-cur, -cur, target, res);
                helper(num, path+"*"+cur, i+1, eval-mult+mult*cur, mult*cur, target, res);
            }
        }
    }
}