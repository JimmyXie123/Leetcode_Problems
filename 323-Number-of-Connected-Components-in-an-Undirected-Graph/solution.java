public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<edges.length; i++){
            uf.Union(edges[i][0], edges[i][1]);
        }
        int res[] = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(res[uf.Find(i)]==0){
                count++;
                res[uf.Find(i)]=1;
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