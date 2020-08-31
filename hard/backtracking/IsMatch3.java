package hard.backtracking;

//https://leetcode-cn.com/problems/regular-expression-matching/
//正则表达式匹配
//IsMatch3是为了方便对比两种算法差异
public class IsMatch3 {
    String s;
    String p;
    int[][] history;
    boolean userBest;
    public boolean isMatch(String s, String p) {
        this.s=s;
        this.p=p;

        history=new int[s.length()+1][p.length()+1];

        return dfs(0,0);
    }

    boolean dfs(int posS,int posP){
        System.out.print(""+posS+" : "+posP);
        String output="";
        if(history[posS][posP]!=0){
            output="  hit";
        }
        System.out.println(output);

        if(posS==s.length()&&posP==p.length())return true;
        if(posP==p.length())return false;

        
        
        if(history[posS][posP]!=0)return history[posS][posP]==1;

        if(posS==s.length()){
            if((p.length()-posP)%2!=0){
                history[posS][posP]=-1;
                return false;
            }
            for(;posP<p.length();posP+=2){
                if(p.charAt(posP+1)!='*'){
                    history[posS][posP]=-1;
                    return false;
                }
            }
            history[posS][posP]=1;
            return true;
        }

        

        if(posP+1<p.length() && p.charAt(posP+1)=='*'){
            if(userBest)return meetStarBest(posS, posP);
            else return meetStar(posS, posP);
        }
        else if(p.charAt(posP)=='.'){
            return dfs(posS+1,posP+1);
        }
        else{
            if(s.charAt(posS)==p.charAt(posP)){
                return dfs(posS+1,posP+1);
            }
            else{
                history[posS][posP]=-1;
                return false;
            }
        }
    }

    private boolean meetStar(int posS, int posP) {
        char ch=p.charAt(posP);
        
        if(dfs(posS,posP+2)){
            history[posS][posP]=1;
            return true;
        }

        if(ch=='.'){
            while(posS<s.length()){
                if(dfs(posS+1,posP+2)){
                    history[posS][posP]=1;
                    return true;
                }
                posS++;
            }
        }
        else{
            while(posS<s.length()&&s.charAt(posS)==ch){
                if(dfs(posS+1,posP+2)){
                    history[posS][posP]=1;
                    return true;
                }
                posS++;
            }
        }
        history[posS][posP]=-1;
        return false;
    }

    private boolean meetStarBest(int posS, int posP) {
        char ch=p.charAt(posP);

        if(ch=='.'||s.charAt(posS)==ch){
            boolean tmp=dfs(posS,posP+2) || dfs(posS+1,posP);
            history[posS][posP]=tmp?1:-1;
            return tmp;
        }
        else{
            boolean tmp=dfs(posS,posP+2);
            history[posS][posP]=tmp?1:-1;
            return tmp;
        }
    }

    public static void main(String[] args) {
        IsMatch3 solution=new IsMatch3();
        IsMatch3 solutionBest=new IsMatch3();
        solutionBest.userBest=true;

        String s="aaabcd";
        String p=".*a.*d";

        System.out.println(s);
        System.out.println(p);
        System.out.println("--------common---------");
        System.out.println(solution.isMatch(s, p));
        System.out.println("");
        System.out.println("--------best---------");
        System.out.println(solutionBest.isMatch(s, p));
    }
}