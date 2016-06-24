public class Solution {
    int m, n;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if(matrix==null||matrix.length==0){
            return result;
        }
        
        row = matrix.length;
        col = matrix[0].length;
        
        int count=0;
        
        while(count*2<row&&count*2<col){
            for(int i=count; i<col-count; i++){
                result.add(matrix[count][i]);
            }
            
            for(int i=count+1; i<row-count; i++){
                result.add(matrix[i][col-count-1]);
            }
            
            if(row-count*2==1||col-count*2==1){
                break;
            }
            
            for(int i=col-count-2; i>=count; i--){
                result.add(matrix[row-count-1][i]);
            }
            
            for(int i=row-count-2; i>count; i--){
                result.add(matrix[i][count]);
            }
            count++;
        }
        return result;
        
    }
    

}