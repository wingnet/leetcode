package TopInterviewQuestions.HeapStackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculate {
    public int calculate(String s) {

        List<String> strs=new ArrayList<>();

        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if("+-*/".indexOf(ch)>=0){
                if(sb.length()>0){
                   strs.add(sb.toString());
                   sb=new StringBuilder();
                }
                strs.add(""+ch);
                
            }
            else if(ch>='0' && ch<='9'){
                sb.append(ch);
            }
        }
        if(sb.length()>0){
            strs.add(sb.toString());
        }

        LinkedList<String> stack=new LinkedList<>();
        for(int i=0;i<strs.size();i++){
            String str=strs.get(i);
            if(str.equals("*") || str.equals("/")){
                int left=Integer.parseInt(stack.pollLast());
                i++;
                int right=Integer.parseInt(strs.get(i));
                int result=str.equals("*")?left*right:left/right;
                stack.addLast(""+result);
            }
            else stack.addLast(str);
        }

        int num=0;
        while(stack.isEmpty()==false){
            String str=stack.pollFirst();
            if("+-".indexOf(str)>=0){
                int right=Integer.parseInt(stack.pollFirst());

                num=str.equals("+")?num+right:num-right;
            }
            else{
                num=Integer.parseInt(str);
            }
        }
        return num;
    }
}