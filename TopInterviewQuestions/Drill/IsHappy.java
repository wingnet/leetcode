package TopInterviewQuestions.Drill;

import java.util.HashSet;

public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n))return false;
            set.add(n);
            int tmp=0;
            while(n>0){
                int tmp1=n%10;
                n=n/10;
                tmp+=tmp1*tmp1;
            }
            n=tmp;
        }
        return true;
    }
}