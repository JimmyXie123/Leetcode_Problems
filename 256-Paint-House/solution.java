public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        int[][] res = new int[costs.length][3];
        for(int i=0; i<costs.length; i++){
            for(int j=0; j<3; j++){
                res[i][j] = costs[i][j];
            }
        }
        
        for(int i=1; i<costs.length; i++){
            res[i][0] = Math.min(res[i-1][1], res[i-1][2])+res[i][0];
            res[i][1] = Math.min(res[i-1][0], res[i-1][2])+res[i][1];
            res[i][2] = Math.min(res[i-1][1], res[i-1][0])+res[i][2];
        }
        return Math.min(Math.min(res[costs.length-1][0], res[costs.length-1][1]), res[costs.length-1][2]);
    }
}