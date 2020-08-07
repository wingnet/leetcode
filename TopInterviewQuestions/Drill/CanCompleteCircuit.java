package TopInterviewQuestions.Drill;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] tmp=new int[gas.length];
        tmp[0]=gas[0]-cost[0];
        int min=tmp[0];
        int minIndex=0;
        for(int i=1;i<tmp.length;i++){
            tmp[i]=tmp[i-1]+gas[i]-cost[i];
            if(tmp[i]<min){
                min=tmp[i];
                minIndex=i;
            }
        }
        if(tmp[tmp.length-1]<0)return -1;
        return minIndex==tmp.length-1?0:minIndex+1;
    }
}