public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null&&t==null){
            return true;
        }
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        for(int i=0; i<s.length(); i++){
            sourcehash[s.charAt(i)]+= i+1;
            targethash[t.charAt(i)]+= i+1;
            if(i==1){
                System.out.println(sourcehash[s.charAt(i)]);
                System.out.println(targethash[t.charAt(i)]);
            }
            if(sourcehash[s.charAt(i)]!=targethash[t.charAt(i)]){
                return false;
            }
        }
        return true;
    }
}