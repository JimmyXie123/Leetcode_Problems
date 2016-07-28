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
        String res = "";
        if(root==null){
            return "{}";
        }
        ArrayList<TreeNode> queue = new ArrayList(); 
        queue.add(root);
        for(int i=0; i<queue.size(); i++){
            TreeNode tmp = queue.get(i);
            if(tmp==null){
                continue;
            }
            queue.add(tmp.left);
            queue.add(tmp.right);
        }
        
        while(queue.get(queue.size()-1)==null){
            queue.remove(queue.size()-1);
        }
        
        res += "{"+queue.get(0).val;
        for(int i=1; i<queue.size(); i++){
            if(queue.get(i)==null){
                res += ",#";
            }else{
                res += ","+queue.get(i).val;
            }
        }
        res += "}";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<TreeNode> queue = new ArrayList();
        String vals[] = data.substring(1, data.length()-1).split(",");
        if(data.length()==2){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for(int i=1; i<vals.length; i++){
            if(!vals[i].equals("#")){
                TreeNode tmp = new TreeNode(Integer.parseInt(vals[i]));
                if(isLeft){
                    queue.get(index).left = tmp; 
                }else{
                    queue.get(index).right = tmp;
                }
                queue.add(tmp);
            }
            if(!isLeft){
                index++;
            }
            isLeft = !isLeft;
       }
       return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));