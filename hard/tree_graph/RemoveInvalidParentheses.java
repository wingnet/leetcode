package hard.tree_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
    boolean[] removePoses;
    String s;
    int leftCount=0;
    int rightCount=0;
    List<String> result;
    int minLen=Integer.MAX_VALUE;
    HashSet<String> set=new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        removePoses=new boolean[s.length()];
        this.s=s;
        result=new ArrayList<>();

        dfs(0,0);

        for (String str : set) {
            result.add(str);
        }

        return result;
    }

    void dfs(int idx,int removeCount){
        //System.out.println(""+idx+" , "+removeCount);
        if(removeCount>minLen)return;

        idx = skipCommonChar(idx);

        if(idx==s.length()){
            if(rightCount==leftCount){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < removePoses.length; i++) {
                    if(!removePoses[i])sb.append(s.charAt(i));
                }
                
                if(removeCount<=minLen){
                    if(removeCount<minLen){
                        set.clear();
                    }
                    
                    minLen=removeCount;
                    set.add(sb.toString());
                    //result.add(sb.toString());
                    //System.out.println(""+removeCount+" : "+sb.toString());
                }
            }
            
            return;
        }

        removePoses[idx]=true;
        dfs(idx+1,removeCount+1);
        removePoses[idx]=false;

        char ch=s.charAt(idx);
        if(ch=='('){
            
            leftCount++;
            dfs(idx+1,removeCount);
            leftCount--;
        }
        else{

            if(rightCount<leftCount){
                rightCount++;
                dfs(idx+1,removeCount);
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
        RemoveInvalidParentheses solution=new RemoveInvalidParentheses();
        String s="()())()";
        List<String> list=solution.removeInvalidParentheses(s);

        for (String string : list) {
            System.out.println(string);
        }
    }
}