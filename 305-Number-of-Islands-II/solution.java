public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m*n);
        List<Integer> res = new ArrayList();
        int count = 0;
        
        for(int i=0; i<positions.length; i++){
            count++;
            grid[positions[i][0]][positions[i][1]] = 1;
            for(int k=0; k<4; k++){
                int nextX = positions[i][0]+dX[k];
                int nextY = positions[i][1]+dY[k];
                if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&grid[nextX][nextY]==1){
                    int node1 = getNum(nextX, nextY, n);
                    int node2 = getNum(positions[i][0], positions[i][1], n);
                    int parent1 = uf.find(node1);
                    int parent2 = uf.find(node2);
                    if(parent1!=parent2){
                        count--;
                        uf.union(parent1, parent2);
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    private int getNum(int x, int y, int n){
        return x*n+y;
    }
}

class UnionFind{
    HashMap<Integer, Integer> father = new HashMap();
    
    public UnionFind(int n){
        for(int i=0; i<n; i++){
            father.put(i, i);
        }
    }
    
    public int find(int x){
        int parent = x;
        while(father.get(parent)!=parent){
            parent = father.get(parent);
        }
        while(father.get(x)!=parent){
            int tmp = father.get(x);
            father.put(x, parent);
            x = tmp;
        }
        return parent;
    }
    
    public void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);
        if(p1!=p2){
            father.put(p1, p2);
        }
    }
}