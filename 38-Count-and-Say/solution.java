public class Solution {
    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        String prev="1";
        if(n==1){
            return prev;
        }
        
        for(int i=0; i<n-1; i++){
            prev = count(prev);
        }
        
        return prev;
        
    }
    
    private String count(String prev){
        StringBuilder tmp = new StringBuilder();
        int count = 0;
        char last = prev.charAt(0);
        int i = 0;
        while(i<prev.length()){
            if(prev.charAt(i)==last){
                count++;
            }else{
                StringBuilder num = new StringBuilder();
                while(count>0){
                    num.append(count%10);
                    count = count/10;
                }
                tmp.append(num.reverse());
                tmp.append(last);
                count=1;
                last = prev.charAt(i);
            }
            i++;
        }
        
        StringBuilder num = new StringBuilder();
        while(count>0){
            num.append(count%10);
            count = count/10;
        }
        tmp.append(num.reverse());
        tmp.append(last);
        return tmp.toString();
    }
}