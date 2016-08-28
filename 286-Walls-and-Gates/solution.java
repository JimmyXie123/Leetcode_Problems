public class Solution {
    int m, n;
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null||rooms.length==0||rooms[0].length==0) return;
        m = rooms.length;
        n = rooms[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0)  helper(rooms, i, j, 0);
            }
        }
    }
    
    private void helper(int[][] rooms, int x, int y, int d){
        if(x<0||x>=m||y<0||y>=n||rooms[x][y]<d)   return;
        rooms[x][y] = d;
        helper(rooms, x+1, y, d+1);
        helper(rooms, x, y+1, d+1);
        helper(rooms, x-1, y, d+1);
        helper(rooms, x, y-1, d+1);
    }
}