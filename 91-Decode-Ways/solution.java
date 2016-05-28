public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        
        int f[] = new int[s.length()+1];
        
        f[0] = 1;
        f[1] = s.charAt(0)!='0'?1:0;
        System.out.println(f[1]);
        for(int i=2; i<s.length()+1; i++){
            if(s.charAt(i-1)!='0'){
                f[i] = f[i-1];
            }
            
            int twodigits = (s.charAt(i-2)-'0')*10 +s.charAt(i-1)-'0';
            if(twodigits>=10&&twodigits<=26){
                f[i] = f[i] + f[i-2];
            }
        }
        
        return f[s.length()];
        
    }
}