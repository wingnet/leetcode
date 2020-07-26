package TopInterviewQuestions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    String s;

    HashMap<Integer,HashSet<Integer>> palins=new HashMap<>();
    LinkedList<LinkedList<String>> paths=new LinkedList<>();
    public List<List<String>> partition(String s) {
        this.s=s;
        for(int i=0;i<s.length();i++){

            growPalindrom(i, i+1);

            growPalindrom(i-1, i+1);
        }

        List<List<String>> result=new ArrayList<>();
        
        goOneStep(new LinkedList<>(), 0);
        while(paths.isEmpty()==false){
            LinkedList<String> onePath=paths.pollFirst();
            int len=0;
            for(String str:onePath)len+=str.length();
            if(len==s.length()){
                result.add(onePath);
            }
            else{
                int pos=len;
                goOneStep(onePath, pos);
            }
        }

        return result;
    }
    private void goOneStep(LinkedList<String> onePath, int pos) {
        if(palins.containsKey(pos)){
            for(int i:palins.get(pos)){
                LinkedList<String> newPath=(LinkedList<String>)(onePath.clone());
                newPath.add(s.substring(pos,i+1));
                paths.addLast(newPath);
            }
        }
        LinkedList<String> newPath=(LinkedList<String>)(onePath.clone());
        newPath.add(s.substring(pos,pos+1));
        paths.addLast(newPath);
    }
    private void growPalindrom(int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
   
            if(palins.containsKey(left)){
                palins.get(left).add(right);
            }
            else{
                HashSet<Integer> set=new HashSet<>();
                set.add(right);
                palins.put(left, set);
            }

            left--;
            right++;
        }

    }


}