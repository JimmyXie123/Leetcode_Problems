/***这道题为什么自顶向下走的时候没个格子的状态是代表当前格子所需生命的最小值呢
 * 还是代表到达那个格子的生命值和所走路径之和呢。这两个在dp传递中都要用到啊。这就是为什么不用自顶向下
*/
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0){
            return 0;
        }
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] res = new int[height][width];
        res[height-1][width-1] = Math.max(-dungeon[height-1][width-1]+1, 1);
        for(int i=height-2; i>=0; i--){
            res[i][width-1] = Math.max(res[i+1][width-1]-dungeon[i][width-1], 1);
        }
        for(int j=width-2; j>=0; j--){
            res[height-1][j] = Math.max(res[height-1][j+1]-dungeon[height-1][j], 1);
        }
        
        for(int i=height-2; i>=0; i--){
            for(int j=width-2; j>=0; j--){
                int temp = Math.min(res[i+1][j], res[i][j+1]);
                res[i][j] = Math.max(temp-dungeon[i][j], 1); 
            }
        }
        return res[0][0];
    }
}