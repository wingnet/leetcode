package TopInterviewQuestions.Drill;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int remain3=i%3;
            int remain5=i%5;
            if(remain3==0&&remain5==0){
                result.add("FizzBuzz");
            }
            else if(remain3==0){
                result.add("Fizz");
            }
            else if(remain5==0){
                result.add("Buzz");
            }
            else{
                result.add(""+i);
            }
        }
        return result;
    }
}