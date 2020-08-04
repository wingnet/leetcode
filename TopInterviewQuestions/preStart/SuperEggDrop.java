package TopInterviewQuestions.preStart;

public class SuperEggDrop {
    int[][] history;

    public int superEggDrop(int K, int N) {
        history=new int[K+1][N+1];

        return DFS(K,N);
    }

    int DFS(int k, int n){
        if(n==0)return 0;
        if(k==1)return n;
        if(k<=0)return -1;

        if(history[k][n]>0)return history[k][n];

        int minSteps=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){

            int failResult=DFS(k-1,i-1);

            int sucResult=DFS(k,n-i);

            if(failResult<0||sucResult<0){
                continue;
            }

            int maxTmp=Math.max(failResult, sucResult);

            minSteps=Math.min(minSteps, maxTmp);

        }
        if(minSteps<Integer.MAX_VALUE){
            history[k][n]=1+minSteps;
        }
        else{
            history[k][n]=-1;
        }
        
        System.out.println("k : "+k+" n : "+n+" result:"+history[k][n]);
        
        return history[k][n];
    }

    public static void main(String[] args){
        SuperEggDrop solution=new SuperEggDrop();
        System.out.println(solution.superEggDrop(3, 14));
    }
}