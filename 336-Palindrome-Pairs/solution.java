public class Solution {
    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList();
        int index1 = 0;
        for(String word:words){
            int index2 = 0;
            for(String tail:words){
                if(word==tail){
                    index2++;
                    continue;
                }
                if(!isPalindrome(word+tail)){
                    index2++;
                    continue;
                }
                List<Integer> ele = new ArrayList();
                ele.add(index1);
                ele.add(index2);
                res.add(ele);
                index2++;
            }
            index1++;
        }
        return res;
    }
}