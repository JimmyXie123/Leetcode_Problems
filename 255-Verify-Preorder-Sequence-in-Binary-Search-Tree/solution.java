public class Solution {
//------------Have to be realized that a preorder array may have many possibilities of trees structures, not only one,
//参考https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space,一碰到突出点，就认为其必须在柚子树上--------------
//
    public boolean verifyPreorder(int[] preorder) {
        long low = Long.MIN_VALUE;
        int index = -1;
        for(int p:preorder){
            if(low>p)   return false;
            while(index>=0&&p>preorder[index]){
                low = preorder[index--];
            }
            preorder[++index] = p; 
        }
        return true;
    }
}