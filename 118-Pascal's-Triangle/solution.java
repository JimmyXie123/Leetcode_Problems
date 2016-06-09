public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if(numRows==0){
            return result;
        }
        List<Integer> temp;
        int i=1;
        while(i<=numRows){
            List<Integer> elem = new ArrayList();
            if(i==1){
                elem.add(1);
            }else if(i==2){
                elem.add(1);
                elem.add(1);
                temp = elem;
            }else{
                elem.add(1);
                int size = temp.size();
                for(int j=0; j<size-1; j++){
                    elem.add(temp.get(j)+temp.get(j+1));
                }
                elem.add(1);
                temp = elem;
            }
            result.add(elem);
            i++;
        }
        return result;
    }
}