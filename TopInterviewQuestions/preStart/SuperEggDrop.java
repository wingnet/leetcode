package TopInterviewQuestions.preStart;

public class SuperEggDrop {
    int[][] history;

    static class Result{
        int fail;
        int success;
        Result(int fail,int success){
            this.fail=fail;
            this.success=success;
        }

        int getDiff(){
            return fail-success;
        }

        int getMax(){
            return Math.max(fail, success);
        }
    }

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

    Result test(int k,int n,int testFloor){
        int failResult=find(k-1,testFloor-1);
        int sucResult=find(k,n-testFloor);

        return new Result(failResult,sucResult);
    }

    int find(int k,int n){
        System.out.println("k:"+k+" n:"+n);
        if(n==0)return 0;

        if(k==1)return n;

        if(n==1)return 1;

        if(history[k][n]>0)return history[k][n];

        int floor=1;
        int ceiling=n;
        while(floor<ceiling){
            int mid=floor+(ceiling-floor)/2;

            Result result=test(k, n, mid);

            if(result.getDiff()==0){
                history[k][n]=result.success+1;
                return history[k][n];
            }
            if(result.getDiff()<0)floor=mid+1;
            else ceiling=mid;
            
        }

        Result result0=test(k,n,floor);

        Result result1=test(k,n,floor-1);
        
        history[k][n]=Math.min(result0.getMax(),result1.getMax())+1;
        return history[k][n];
    }

    public static void main(String[] args){
        SuperEggDrop solution=new SuperEggDrop();
        //System.out.println(solution.superEggDrop(2, 6));
        System.out.println(solution.superEggDrop(2, 14));
    }
}