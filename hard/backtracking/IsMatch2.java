package hard.backtracking;

//https://leetcode-cn.com/problems/regular-expression-matching/
//正则表达式匹配
//18ms
//main中是对IsMatch1和IsMatch2进行对比测试的代码
public class IsMatch2 {
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
        System.out.print(""+posS+" : "+posP);
        if(posS==s.length()&&posP==p.length())return true;
        if(posP==p.length())return false;

        String output="";
        if(history[posS][posP]!=0){
            output="  hit";
        }
        System.out.println(output);
        
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
        IsMatch2 solution2=new IsMatch2();
        IsMatch1 solution1=new IsMatch1();

        String s="aaabcd";
        String p=".*abcd";

        System.out.println(s);
        System.out.println(p);
        System.out.println("--------IsMatch1---------");
        System.out.println(solution1.isMatch(s, p));
        System.out.println("");
        System.out.println("--------IsMatch2---------");
        System.out.println(solution2.isMatch(s, p));
    }
}