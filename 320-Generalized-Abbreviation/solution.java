public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList();
        char[] path = word.toCharArray();
        DFS(res, path, word, 0);
        return res;
    }
    
    private void DFS(List<String> res, char[] path, String word, int pos){
        String tmp="";
        int count = 0;
        int k=0;
        int len = path.length;
        while(k<len){    //------------跳格的都得用while-----------------
            if(path[k]!='1'){
                tmp += path[k];
                k++;
            }else{
                int pointer = 0;
                while(k+pointer<len&&path[pointer+k]=='1'){
                    pointer++;
                    count++;
                }
                tmp += pointer;
                k = k+pointer;
            }
        }
        res.add(tmp);
        
        if(pos==len){
            return;
        }
        
        for(int i=pos; i<len; i++){
            char temp = path[i];
            path[i] = '1';
            DFS(res, path, word, i+1);
            path[i] = temp;
        }
    }
}