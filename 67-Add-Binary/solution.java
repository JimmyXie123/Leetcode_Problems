public class Solution {
    public String addBinary(String a, String b) {
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        int len = Math.min(a.length(), b.length());
        String a1 = new StringBuilder(a).reverse().toString();
        String b1 = new StringBuilder(b).reverse().toString();
        
        StringBuilder res = new StringBuilder(); 
        
        int advance = 0;
        for(int i=0; i<len; i++){
            int sum = (a1.charAt(i)+b1.charAt(i)-'0'-'0')+advance;  //---------char '0' <-> int 48---
            if(sum>=2){
                sum = sum-2;
                advance =1;
            }else{
                advance =0;
            }
            res.append(sum);
        }
        
        String c;
        if(a.length()>b.length()){
            c = a1;
        }else{
            c = b1;
        }
        for(int i=len; i<c.length(); i++){
                int sum = c.charAt(i)-'0'+advance;
                if(sum>=2){
                    sum = sum-2;
                    advance =1;
                }else{
                    advance =0;
                }
                res.append(sum);
        }
        if(advance==1){
            res.append(1);
        }
        String result = res.reverse().toString();
        return result;
    }
}