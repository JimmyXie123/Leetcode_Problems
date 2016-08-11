public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m*n);
        int[][] rectangle = new int[m][n];
        List<Integer> res = new ArrayList();
        int number = 0;
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<positions.length; i++){
            number++;
            int node = positions[i][0]*n+positions[i][1];     //----------乘n不是乘m啊---------------
            rectangle[positions[i][0]][positions[i][1]] = 1;
            for(int j=0; j<4; j++){
                int nextX = positions[i][0] + dX[j];
                int nextY = positions[i][1] + dY[j];
                if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&rectangle[nextX][nextY]==1){
                    //System.out.println(node+" "+(nextX*m+nextY));
                    int nid = nextX*n+nextY;
                    int parent1 = uf.find(node);
                    int parent2 = uf.find(nid);
                    if(parent1!=parent2){
                        number--;
                        uf.union(parent1, parent2);       //------union时候一定是两个father union啊-------------
                    }
                    //take care of the order, it matters in this problem if u dont find() on all nodes
                }
            }
            
            res.add(number);
        }
        return res;
    }
}

class UnionFind{
    HashMap<Integer, Integer> map = new HashMap();
    public UnionFind(int n){
        for(int i=0; i<n; i++){
            map.put(i, i);
        }
    }
    
    public int find(int node){
        int parent = map.get(node);
        while(parent!=map.get(parent)){
            parent = map.get(parent);
        }
        int mid = map.get(node);
        while(map.get(mid)!=parent){
            int tmp = map.get(mid);
            map.put(mid, parent);
            mid = tmp;
        }
        return parent;
    }
    
    public void union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        map.put(node1, node2);
    }
}