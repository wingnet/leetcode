package hard.tree_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses1 {
    boolean[] removePoses;
    String s;
    int leftCount=0;
    int rightCount=0;
    List<String> result;
    int minLen=Integer.MAX_VALUE;
    HashSet<String> set=new HashSet<>();

    int wastedLeft=0;
    int wastedright=0;

    public List<String> removeInvalidParentheses(String s) {
        removePoses=new boolean[s.length()];
        this.s=s;
        result=new ArrayList<>();

        getLRCount();

        dfs(0,0,0);

        for (String str : set) {
            result.add(str);
        }

        return result;
    }

    void getLRCount(){
        
        int leftCount0=0;
        int rightCount0=0;
        for (char ch : s.toCharArray()) {
            if(ch=='(')leftCount0++;
            if(ch==')'){
                if(leftCount0>rightCount0)rightCount0++;
                else wastedright++;
            }
        }
        wastedLeft=leftCount0-rightCount0;
    }

    void dfs(int idx,int leftRemove,int rightRemove){
        //System.out.println(""+idx+" , "+removeCount);
        if(leftRemove>wastedLeft || rightRemove>wastedright)return;

        idx = skipCommonChar(idx);

        if(idx==s.length()){
            if(rightCount==leftCount){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < removePoses.length; i++) {
                    if(!removePoses[i])sb.append(s.charAt(i));
                }
                

                    set.add(sb.toString());
                    //result.add(sb.toString());
                    //System.out.println(""+removeCount+" : "+sb.toString());

            }
            
            return;
        }

        

        char ch=s.charAt(idx);
        if(ch=='('){
            removePoses[idx]=true;
            dfs(idx+1,leftRemove+1,rightRemove);
            removePoses[idx]=false;

            leftCount++;
            dfs(idx+1,leftRemove,rightRemove);
            leftCount--;
        }
        else{
            removePoses[idx]=true;
            dfs(idx+1,leftRemove,rightRemove+1);
            removePoses[idx]=false;

            if(rightCount<leftCount){
                rightCount++;
                dfs(idx+1,leftRemove,rightRemove);
                rightCount--;
            }
            
        }

    }

    private int skipCommonChar(int idx) {
        while(idx<s.length()){
            char ch=s.charAt(idx);
            if(ch!='('&&ch!=')'){
                idx++;
            }
            else break;
        }
        return idx;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses1 solution=new RemoveInvalidParentheses1();
        String s="()())()";
        List<String> list=solution.removeInvalidParentheses(s);

        for (String string : list) {
            System.out.println(string);
        }
    }
}