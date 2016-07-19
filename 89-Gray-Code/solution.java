public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        if(n<=1){
            for(int i=0; i<=n; i++){
                res.add(i);
            }
            return res;
        }
        res = grayCode(n-1);
        List<Integer> reverse = reverse(res);
        int tmp = 1<<(n-1);
        for(int i=0; i<reverse.size(); i++){
            reverse.set(i, reverse.get(i)+tmp);
        }
        res.addAll(reverse);
        return res;
    }
    
    private List<Integer> reverse(List<Integer> cur){
        List<Integer> res = new ArrayList();
        for(int i=cur.size()-1; i>=0; i--){
            res.add(cur.get(i));
        }
        return res;
    }
}