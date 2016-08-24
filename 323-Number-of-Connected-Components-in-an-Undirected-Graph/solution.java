public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for(int i=0; i<edges.length; i++){
            int parent_A = uf.find(edges[i][0]);
            int parent_B = uf.find(edges[i][1]);
            if(parent_A!=parent_B){
                count--;
                uf.union(parent_A, parent_B);
            }
        }
        return count;
    }
}

class UnionFind{
    HashMap<Integer, Integer> father = new HashMap();
    public UnionFind(int n){
        for(int i=0; i<n; i++){
            father.put(i, i);
        }
    }
    public int find(int n){
        int parent = n;
        while(father.get(parent)!=parent){
            parent = father.get(parent);
        }
        while(father.get(n)!=parent){
            int tmp = father.get(n);
            father.put(n, parent);
            n = tmp;
        }
        return parent;
    }
    
    public void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_x!=parent_y){
            father.put(parent_x, parent_y);
        }
    }
}