public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null||rooms.length==0||rooms[0].length==0) return;
        Queue<Integer> queue = new LinkedList();
        m = rooms.length;
        n = rooms[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0) queue.offer(getNum(i, j));
            }
        }
        
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int curr = queue.poll();
                int x = curr/n;
                int y = curr%n;
                for(int k=0; k<4; k++){
                    int nextX = x+dX[k];
                    int nextY = y+dY[k];
                    if(nextX>=0&&nextX<m&&nextY<n&&nextY>=0&&rooms[nextX][nextY]>level){
                        rooms[nextX][nextY] = level;
                        queue.offer(getNum(nextX, nextY));
                    }
                }
            }
        }
    }
    
    private int getNum(int x, int y){
        return x*n+y;
    }
}