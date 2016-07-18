public class Solution {
    public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[3][9] = skip[9][3] = 6;
        skip[1][7] = skip[7][1] = 4;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        boolean visited[] = new boolean[10];
        int res = 0;
        for(int i=m; i<=n; i++){
            res += helper(visited, skip, 2, i-1)*4+helper(visited, skip, 1, i-1)*4+helper(visited, skip, 5, i-1);
        }
        
        return res;
    }
    
    private int helper(boolean[] visited, int[][] skip, int cur, int rest){
        if(rest==0){
            return 1;
        }
        if(rest<0){
            return 0;
        }
        int res = 0;
        visited[cur] = true;
        for(int i=1; i<=9; i++){
            if(!visited[i]&&(skip[cur][i]==0||visited[skip[cur][i]]==true)){
                res += helper(visited, skip, i, rest-1); 
            }
        }
        visited[cur] = false;
        return res;
    }
}