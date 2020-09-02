package hard.other;

import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {
    int[][] people;
    public int[][] reconstructQueue(int[][] people) {
        if(people.length<2)return people;

        this.people=people;
        Arrays.sort(people,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        
        LinkedList<int[]> result=new LinkedList<>();

        for(int i=0;i<people.length;i++){
            int[] cur=people[i];
            int height=cur[0];
            int curCount=cur[1];

            int count=0;
            boolean flag=false;

            for(int j=0;j<result.size();j++){
                int tmpH=result.get(j)[0];
                if(count==curCount&&tmpH>=height){
                    result.add(j, cur);
                    flag=true;
                    break;
                }
                if(tmpH>=height)count++;
            }
            if(flag==false)result.addLast(cur);
        }

        int[][] tmp=new int[result.size()][];
        for(int i=0;i<tmp.length;i++){
            tmp[i]=result.get(i);
        }

        return tmp;
    }

    public static void main(String[] args) {
        ReconstructQueue solution=new ReconstructQueue();
        int[][] people={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        solution.reconstructQueue(people);
    }
}