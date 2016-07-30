public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n=grid[0].length;
        
        ArrayList<Integer> I = new ArrayList();
        ArrayList<Integer> J = new ArrayList();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    I.add(i);
                    J.add(j);
                }
            }
        }
        
        return getMin(I)+getMin(J);
    }
    
    private int getMin(ArrayList<Integer> List){
        int res = 0;
        Collections.sort(List);
        int i=0; 
        int j=List.size()-1;
        while(i<j){
            res += List.get(j--)-List.get(i++);
        }
        return res;
    }
}