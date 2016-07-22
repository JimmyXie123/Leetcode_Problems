public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n!=edges.length+1){
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<edges.length; i++){
            if(uf.Find(edges[i][0])==uf.Find(edges[i][1])){
                return false;
            }
            uf.Union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}

class UnionFind{
    HashMap<Integer, Integer> father = new HashMap();
    public UnionFind(int n){
        for(int i=0; i<n; i++){
            father.put(i, i);
        }
    }
    
    public int Find(int x){
        int parent = father.get(x);
        while(father.get(parent)!=parent){
            parent = father.get(parent);
        }
        
        int temp = -1;
        int fa = father.get(x);
        while(fa!=father.get(fa)){
            temp = father.get(fa);
            father.put(fa, parent);
            fa = temp;
        }
        return parent;
    }
    
    public void Union(int x, int y){
        int fa1 = Find(x);
        int fa2 = Find(y);
        father.put(fa1, fa2);
    }
}