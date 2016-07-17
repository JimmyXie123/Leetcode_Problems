public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='-'||
            input.charAt(i)=='+'||
            input.charAt(i)=='*'){
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i+1, input.length()));
                for(int i1:res1){
                    for(int i2:res2){
                        if(input.charAt(i)=='+'){
                            res.add(i1+i2);
                        }else if(input.charAt(i)=='-'){
                            res.add(i1-i2);
                        }else{
                            res.add(i1*i2);
                        }
                    }
                }
            }
        }
        
        if(res.size()==0){
            res.add(Integer.valueOf(input));    //-----------Dont forget the exit of the recursion----------------
        }
        return res;
        
    }
}