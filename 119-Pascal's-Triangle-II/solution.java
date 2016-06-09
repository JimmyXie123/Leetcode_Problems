public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = null;
        rowIndex++;
        int i=1;
        while(i<=rowIndex){
            List<Integer> result = new ArrayList();
            if(i==1){
                result.add(1);
                temp = result;
                i++;
            }else{
                result.add(1);
                int size = temp.size();
                for(int j=0; j<size-1; j++){
                    result.add(temp.get(j)+temp.get(j+1));
                }
                result.add(1);
                temp = result;
                i++;
            }
        }
        
        return temp;
        
    }
}