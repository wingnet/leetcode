package TopInterviewQuestions.aboutMath;

import java.util.HashMap;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";

        StringBuilder sb=new StringBuilder();
        if(numerator<0^denominator<0)sb.append('-');
        long num=Math.abs(Long.valueOf(numerator));
        long den=Math.abs(Long.valueOf(denominator));

        sb.append(num/den);
        if(num%den==0)return sb.toString();

        sb.append('.');
        long remainder=num%den;
        HashMap<Long,Integer> his=new HashMap<>();
        while(remainder!=0){
            if(his.containsKey(remainder)){
                sb.insert(his.get(remainder),"(");
                sb.append(')');
                return sb.toString();
            }
            his.put(remainder, sb.length());
            remainder*=10;
            sb.append(remainder/den);
            remainder=remainder%den;
        }
        return sb.toString();
    }
}