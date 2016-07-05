public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append((numerator>0)^(denominator>0)?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num/den);
        num = num%den;
        if(num==0){
            return new String(res);
        }
        
        res.append(".");
        HashMap<Long, Integer> map = new HashMap();
        while(num!=0){
            num *= 10;
            long tmp = num/den;
            if(map.containsKey(num)){
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            }else{
                map.put(num, res.length());
                num = num%den;
                res.append(tmp);
            }
        }
        return new String(res);
    }
}