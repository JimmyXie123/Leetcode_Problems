/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        boolean eof = false;
        int total = 0;
        
        while(!eof&&total<n){
            int num = read4(tmp);
            if(num<4){
                eof = true;
            }
            
            int len = Math.min(n-total, num);
            for(int i=0; i<len; i++){
                buf[total++] = tmp[i];
            }
            
        }
        return total;
    }
}