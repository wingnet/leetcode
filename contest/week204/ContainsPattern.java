package contest.week204;

public class ContainsPattern {
    int[] arr;
    int m;
    int k;
    public boolean containsPattern(int[] arr, int m, int k) {
        this.arr=arr;
        this.m=m;
        this.k=k;

        for(int i=0;i<=arr.length-m;i++){
            int count=1;
            for(int j=i+m;j<=arr.length-m;j+=m){

                if(compare(i, j)){
                    count++;
                }
                else break;

                System.out.println(""+i+" , "+j+ " , "+count);
                if(count>=k)return true;
            }
            
        }

        return false;
    }

    private boolean compare(int i, int j) {
        int h=0;
        for(;h<m;h++){
            if(arr[i+h]!=arr[j+h])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ContainsPattern solution=new ContainsPattern();
        // int[] arr={1,2,4,4,4,4};
        // int m=1;
        // int k=3;
        // int[] arr={5,1,2,4,1,2,1,1,1,3};
        // int m=2;
        // int k=2;
        int[] arr={2,2,1,2,2,1,1,1,2,1};
        int m=2;
        int k=2;
        System.out.println( solution.containsPattern(arr, m, k));
    }
}