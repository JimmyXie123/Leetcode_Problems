public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0){
            return 0;
        }
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] res = new int[height][width];
        res[0][0] = dungeon[0][0];
        for(int i=1; i<height; i++){
            res[i][0] = res[i-1][0]+dungeon[i][0];
        }
        for(int i=1; i<width; i++){
            res[0][i] = res[0][i-1]+dungeon[i][0];
        }
        
        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                res[i][j] = Math.min(res[i-1][j], res[i][j-1])+dungeon[i][j];
            }
        }
        
        return (res[height-1][width-1]<0)?-res[height-1][width-1]:0;
    }
}