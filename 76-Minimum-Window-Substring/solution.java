//---------Think about y this problem dont directly use hashmap---------------
public class Solution {
    private int inithash(String t, int targethash[]){
        int sum = 0; 
        for(char ele:t.toCharArray()){
            sum++;
            targethash[ele]++;   //------------pay attention to the char to int dicrectly in array index------ 
        }
        return sum;
    }
    public String minWindow(String s, String t) {
        int targethash[] = new int[256];
        int sourcehash[] = new int[256];
        String res = "";
        int min = Integer.MAX_VALUE;
        
        int targetnum = inithash(t, targethash);
        int sourcenum = 0;
        
        int j=0;
        for(int i=0; i<s.length(); i++){
            if(targethash[s.charAt(i)]>0){
                //sourcehash[s.charAt(i)]++;     
                //-----------if we use hashmap here, how will we deal with sourcenum and targetnum--------------
                sourcenum++;
            }
            targethash[s.charAt(i)]--;
            while(sourcenum>=targetnum){
                if(min>i-j+1){
                    min = i-j+1;
                    res = s.substring(j, i+1);
                }
                targethash[s.charAt(j)]++;
                if(targethash[s.charAt(j)]>0){
                    sourcenum--;
                }
                j++;
            }
        }
        return res;
    }
}