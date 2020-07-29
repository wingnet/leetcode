package TopInterviewQuestions.string;
import java.util.HashMap;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> counters=new HashMap<>();

        for(char ch:s.toCharArray()){
            counters.put(ch,counters.getOrDefault(ch, 0)+1);
        }

        for(char ch:t.toCharArray()){
            if(counters.containsKey(ch)==false)return false;
            int count=counters.get(ch);
            count--;
            if(count==0)counters.remove(ch);
            else counters.put(ch, count);
        }
        if(counters.isEmpty())return true;
        return false;
    }
}