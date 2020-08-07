package TopInterviewQuestions.preStart;

public class SuperEggDrop {
    int[][] history;

    public int superEggDrop(int K, int N) {
        history=new int[K+1][N+1];

        return find(K,N);
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
        
        //System.out.println("k : "+k+" n : "+n+" result:"+history[k][n]);
        
        return history[k][n];
    }

    int find(int k,int n){
        System.out.println("k:"+k+" n:"+n);
        if(n==0)return 0;
        
        if(k<=0)return -1;
        if(k==1)return n;

        if(n==1)return 1;

        if(history[k][n]>0)return history[k][n];

        int floor=1;
        int ceiling=n;
        int diff=0;
        int failResult=0;
        int sucResult=0;
        while(floor<ceiling){
            int mid=floor+(ceiling-floor)/2;

            failResult=find(k-1,mid-1);

            sucResult=find(k,n-mid);
            diff=failResult-sucResult;
            if(diff<0)floor=mid+1;
            else ceiling=mid;
        }

        int next=floor-1;
        int fail2=find(k-1,next-1);
        int success2=find(k,n-next);
        int diff2=success2-fail2;
        int result=failResult;
        if(diff2<diff){
            result=success2;
        }
        history[k][n]=result;
        return result;
    }

    public static void main(String[] args){
        SuperEggDrop solution=new SuperEggDrop();
        System.out.println(solution.superEggDrop(2, 6));
    }
}