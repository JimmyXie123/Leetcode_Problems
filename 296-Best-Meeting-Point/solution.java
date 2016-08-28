public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)   return 0;
        
        ArrayList<Integer> row = new ArrayList();
        ArrayList<Integer> col = new ArrayList();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    row.add(j);
                    col.add(i);
                }
            }
        }
        
        Collections.sort(row);
        Collections.sort(col);
        
        int res = 0;
        int start = 0;
        int end = row.size()-1;
        while(end>start){
            res += row.get(end)-row.get(start);
            end--;
            start++;
        }
        
        start=0;
        end=col.size()-1;
        while(end>start){
            res+=col.get(end)-col.get(start);
            end--;
            start++;
        }
        return res;
    }
}