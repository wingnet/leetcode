package hard.backtracking;


public class IsMatch1 {
    String s;
    String p;
    int[][] history;
    public boolean isMatch(String s, String p) {
        this.s=s;
        this.p=p;

        history=new int[s.length()+1][p.length()+1];

        return dfs(0,0);
    }

    boolean dfs(int posS,int posP){
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

    public static void main(String[] args) {
        IsMatch1 solution=new IsMatch1();
        // String s="aab";
        // String p="c*a*b";
        String s="a";
        String p="ab*";
        System.out.println(solution.isMatch(s, p));
    }
}