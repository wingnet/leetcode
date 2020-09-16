package misc.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CalcEquation {
    List<List<String>> equations;
    double[] values;
    LinkedList<String> history;
    HashSet<String> vars;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.equations=equations;
        this.values=values;

        vars=new HashSet<>();
        for(List<String> equ:equations){
            vars.add(equ.get(0));
            vars.add(equ.get(1));
        }
        
        history=new LinkedList<>();

        double[] results=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String> query=queries.get(i);
            if(vars.contains(query.get(0))&&vars.contains(query.get(1))){
                results[i]=dfs(query.get(0),query.get(1),1.0);
            }
            else results[i]=-1;
        }

        return results;
    }

    double dfs(String start,String end,double curResult){
        
        if(start.equals(end))return curResult;

        if(history.contains(start))return -1;

        for(int i=0;i<equations.size();i++){
            List<String> strs=equations.get(i);
            double value=values[i];

            String next=null;
            double tmp=curResult;

            if(history.contains(strs.get(0))||history.contains(strs.get(1))){
                continue;
            }
            

            if(strs.get(0).equals(start)){
                tmp*=value;
                next=strs.get(1);

            }
            else if(strs.get(1).equals(start)){
                tmp*=(1.0/value);
                next=strs.get(0);

            }

            if(next!=null){
                history.addLast(start);
                double result=dfs(next,end,tmp);
                history.removeLast();

                if(result!=-1)return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CalcEquation solution=new CalcEquation();

    }
}
