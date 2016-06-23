//-------------同combination sum
public class Solution {
int res = Integer.MAX_VALUE;
public int numSquares(int n) {
    int num = 1;
    while (num * num <= n) {
        num++;
    } 
    num--;
    ArrayList<Integer> element = new ArrayList<Integer>();
    for (int j = num; j > 0; j--) {
        element.add(j*j);
    }
    helper(n, element, 0, 0, 0);
    return res;
}
public void helper(int n, ArrayList<Integer> element, int pos, int sum, int level) {
    if (level > res) { //cut redundancy 
        return;
    }
    if (sum > n) {
        return;
    }
    if (sum == n) {
        res = Math.min(level, res);
        return;
    }
    for (int i = pos; i < element.size(); i++) {
        sum += element.get(i);
        helper(n, element, i, sum, level + 1);
        sum -= element.get(i);

    }
}