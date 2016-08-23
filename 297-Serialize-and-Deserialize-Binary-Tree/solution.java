/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)  return "{}";
        ArrayList<TreeNode> queue = new ArrayList();
        queue.add(root);
        for(int i=0; i<queue.size(); i++){
            if(queue.get(i)!=null){
                queue.add(queue.get(i).left);
                queue.add(queue.get(i).right);
            }
        }
        while(queue.get(queue.size()-1)==null)  queue.remove(queue.size()-1);
        
        String encode ="";
        for(int i=0; i<queue.size(); i++){
            if(i==0) {
                encode += "{"+queue.get(i).val;
                continue;
            }
            if(queue.get(i)==null) {
                encode += ",#";
                continue;
            }
            encode += ","+queue.get(i).val;
        }
        encode += "}";
        return encode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="{}")  return null;
        String decode = data.substring(1, data.length()-1);
        String[] strs = decode.split(",");
        //if(strs[0]=="#")  return null;
        
        ArrayList<TreeNode> queue = new ArrayList();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.add(root);
        boolean isLeft = true;
        int index = 0;
        
        for(int i=1; i<strs.length; i++){
            TreeNode curr;
            if(strs[i].equals("#")){
                curr = null;
            }else{
                curr = new TreeNode(Integer.parseInt(strs[i]));
            }
            
            if(isLeft){
                queue.get(index).left = curr;
                isLeft = false;
            }else{
                queue.get(index).right = curr;
                isLeft = true;
                index++;
            }
            if(curr!=null)  queue.add(curr);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));