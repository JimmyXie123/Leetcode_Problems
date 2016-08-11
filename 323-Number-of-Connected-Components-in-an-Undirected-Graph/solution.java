public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        for(int i=0; i<edges.length; i++){
            int parent1 = uf.Find(edges[i][0]);
            int parent2 = uf.Find(edges[i][1]);
            if(parent1!=parent2){
                count--;
                uf.Union(parent1, parent2);
            }
        }
        return count;
    }
}

class UnionFind{
    HashMap<Integer, Integer> map = new HashMap();
    public UnionFind(int n){
        for(int i=0; i<n; i++){
            map.put(i,i);
        }
    }
    
    public int Find(int x){
        int parent = map.get(x);
        while(parent!=map.get(parent)){
            parent = map.get(parent);
        }
        
        int temp = -1;
        int fa = map.get(x);
        while(fa!=map.get(fa)){
            temp = map.get(fa);
            map.put(fa,parent);
            fa = temp;
        }
        return parent;
    }
    
    public void Union(int x, int y){
        int fa1 = Find(x);
        int fa2 = Find(y);
        map.put(fa1, fa2);
    }
}