public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num==null){
            return false;
        }
        String dic = "69180";
        int len = num.length();
        //HashMap<Integer, Character> map = new HashMap();
        for(int i=0; i<len; i++){
            if(!dic.contains(""+num.charAt(i))){
                return false;
            }
            if(num.charAt(i)=='1'&&num.charAt(len-i-1)=='1'){
                continue;
            }else if(num.charAt(i)=='0'&&num.charAt(len-i-1)=='0'){
                System.out.println("123");
                continue;
            }else if(num.charAt(i)=='6'&&num.charAt(len-i-1)=='9'){
                continue;
            }else if(num.charAt(i)=='9'&&num.charAt(len-i-1)=='6'){
                continue;
            }else if(num.charAt(i)=='8'&&num.charAt(len-i-1)=='8'){
                continue;
            }
            return false;
            
            
        }
        return true;
    }
}