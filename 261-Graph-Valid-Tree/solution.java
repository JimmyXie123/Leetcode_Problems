public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n!=edges.length+1){
            return false;         //---------好囧－－－－－－－－－－－－－－
        }
        
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<edges.length; i++){
            int p1 = uf.find(edges[i][0]);
            int p2 = uf.find(edges[i][1]);
            if(p1==p2){
                return false;
            }else{
                uf.union(p1, p2);
            }
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
        int parent_A = find(x);
        int parent_B = find(y);
        if(parent_A!=parent_B){
            father.put(parent_A, parent_B);
        }
    }
}