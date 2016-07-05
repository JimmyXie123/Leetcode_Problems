public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        StringBuilder str = new StringBuilder();
        str.append(((numerator>0)^(denominator>0))?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long tmp = num/den;
        str.append(tmp);
        num = num%den;
        if(num==0){
            return new String(str);
        }
        
        HashMap<Long, Integer> map = new HashMap();
        str.append(".");
        while(num!=0){
            num *= 10;
            tmp = num/den;
            if(map.containsKey(num)){
                System.out.println(num);
                str.insert(map.get(num), "(");
                str.append(")");
                break;
            }else{
                map.put(num, str.length());
                str.append(tmp);
                num = num%den;
            }
            
        }
        return new String(str);
        
    }
}