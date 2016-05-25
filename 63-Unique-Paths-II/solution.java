public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0){
            return 0;
        }
        
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int result[][] = new int[height][width];
        
        if(obstacleGrid[0][0]==1){
            result[0][0] = 0;
        }else{
            result[0][0] = 1;
        }
        for(int i=1; i<height; i++){
            if(obstacle[i][0]==0){
                result[i][0] = result[i-1][0];
            }else{
                result[i][0] = 0;
            }
        }
        for(int j=1; j<width; j++){
            if(obstacle[0][j]==0){
                result[0][j] = result[0][j-1];
            }else{
                result[0][j] = 0;
            }
        }
        
        for(int i=1; i<height; i++)
            for(int j=1; j<width; j++)
                {   
                    if(obstacleGrid[i][j]==0){
                        result[i][j] = result[i-1][j] + result[i][j-1];
                    }else{
                        result[i][j] = 0;
                    }
                }
        return result[height-1][width-1];
    }
}