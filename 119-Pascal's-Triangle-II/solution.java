public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList();
        for(int i:result){
            System.out.println(i);
        }
        List<Integer> temp = null;
        rowIndex++;
        int i=1;
        while(i<=rowIndex+1){
            result.clear();
            if(i==1){
                result.add(1);
                temp = result;
                i++;
                
                for(int i:result){
                    System.out.println(i);
                }
            }else{
                result.add(1);
                int size = temp.size();
                for(int j=0; j<size-1; j++){
                    result.add(temp.get(i)+temp.get(i+1));
                }
                result.add(1);
                temp = result;
                i++;
            }
        }
        
        return temp;
        
    }
}