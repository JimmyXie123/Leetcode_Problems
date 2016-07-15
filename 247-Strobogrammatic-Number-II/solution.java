public class Solution {
    HashMap<Character, Character> map = new HashMap();
        
    public List<String> findStrobogrammatic(int n) {
        map.put('0', '0');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        
        List<String> res = new ArrayList();                                      
                                                                //-----------1的异常情况--------------
       /* if(n==1){
            res.add("0");       
            res.add("1");
            res.add("8");
            return res;
        }*/
        
        char[] tmp = new char[n];
        
        helper(res, tmp, 0, n);
        return res;
    }
    
    private void helper(List<String> res, char[] tmp, int pos, int n){
        if(pos>(n+1)/2-1){                            //-----------坐标问题，别忘减一-------------
            res.add(new String(tmp));
            return;
        }
        
        for(char ch:map.keySet()){
            if(n!=1&&pos==0&&ch=='0'){
                continue;
            }
            if(((n==1)||(n%2==1&&pos==(n+1)/2-1))&&(ch=='6'||ch=='9')){      //-----------坐标问题同上--------------
                continue;
            }
            tmp[pos] = ch;
            tmp[n-pos-1] = map.get(ch);
            helper(res, tmp, pos+1, n);
        }
    }
}