public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList();
        int wordCount = words.length;
        int curLen = 0;
        int lastI = 0;
        for(int i=0; i<=wordCount; i++){
            if(i==words.length||curLen+words[i].length()+i-lastI>maxWidth){
                StringBuilder tmp = new StringBuilder();
                int spaceCount = maxWidth - curLen;
                int spaceSlots = i-lastI-1;
                if(spaceSlots==0||i==wordCount){
                    for(int k=lastI; k<i; k++){
                        tmp.append(words[k]);
                        if(k!=i-1)
                            appendSpace(tmp, 1);
                    }
                    appendSpace(tmp, maxWidth-tmp.length());
                }else{
                    int spaceEach = spaceCount/spaceSlots;
                    int spaceExtra = spaceCount%spaceSlots;
                    for(int k=lastI; k<i; k++){
                        tmp.append(words[k]);
                        if(k!=i-1){
                            appendSpace(tmp, spaceEach+(k-lastI>=spaceExtra?0:1));
                        }
                    }
                }
                res.add(tmp.toString());
                curLen = 0;
                lastI = i;
            }
            if(i!=wordCount){
                curLen += words[i].length();
            }
        }
        return res;
    }
    
    private void appendSpace(StringBuilder s, int count){
        for(int i=0; i<count; i++){
            s.append(" ");
        }
    }
}