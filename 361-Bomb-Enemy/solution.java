public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0, rowhits=0, colhits[] = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==0||grid[i][j-1]=='W'){
                    rowhits = 0;
                    for(int k=j; k<n&&grid[i][k]!='W'; k++){
                        if(grid[i][k]=='E'){
                            rowhits++;
                        }
                    }
                }
                
                if(i==0||grid[i-1][j]=='W'){
                    colhits[j] = 0;
                    for(int k=i; k<m&&grid[k][j]!='W'; k++){
                        if(grid[k][j]=='E'){
                            colhits[j]++;
                        }
                    }
                }
                if(grid[i][j]=='0'){
                    max = Math.max(max, rowhits+colhits[j]);
                }
            }
        }
        return max;
        
    }
}