public class Solution {
    public String simplifyPath(String path) {
        String result = "/";
        String[] stubs = path.split("/");
        ArrayList<String> paths = new ArrayList();
        for(String s:stubs){
            if(s.equals("..")){
                if(paths.size()>0){
                    paths.remove(paths.size()-1);
                }
            }else if(!s.equals(".")&&!s.equals("")){
                paths.add(s);
            }
        }
        
        for(int i=0; i<paths.size()-1; i++){
            result += paths.get(i)+"/";
        }
        if(paths.size()-1>=0){
            result += paths.get(paths.size()-1);
        }
            
        return result;
    }
}