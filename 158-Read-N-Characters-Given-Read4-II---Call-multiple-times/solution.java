/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPtr = 0;
    private int buffCount = 0;
    private char[] tmp = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n){
            if(buffPtr==0){
                buffCount = read4(tmp);
            }
            if(buffCount==0) break;
            while(ptr<n&&buffPtr<buffCount){
                buf[ptr++] = tmp[buffPtr++];
            }
            if(buffPtr==buffCount)  buffPtr = 0;
        }
        return ptr;
    }
}