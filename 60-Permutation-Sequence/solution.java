public class Solution {
    int count = 0;
    public String getPermutation(int n, int k) {
        if(k<1) return "";
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        helper(sb, n, k, visited);
        return sb.toString();
    }
    
    private void helper(StringBuilder sb, int n, int k, boolean[] visited){
        if(sb.length()==n) {
            count++;
            return;
        }
        
        for(int i=1; i<=n; i++){
            if(visited[i])  continue;
            sb.append(i);
            visited[i] = true;
            helper(sb, n, k, visited);
            if(count==k)  break;
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}