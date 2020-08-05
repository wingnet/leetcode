package TopInterviewQuestions.aboutMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.DelayQueue;

public class MaxPoints {
    ArrayList<Double> lines=new ArrayList<>();
    ArrayList<Integer> counts=new ArrayList<>();
    double delta=0.000001;
    public int maxPoints(int[][] points) {

        
        for(int i=1;i<points.length;i++){
            int[] newPoint=points[i];
            for(int j=0;j<i;j++){
                int[] old=points[j];
                double line=getLine(old, newPoint);
                
            }
        }

        return 0;
        
    }

    void addLine(double line){
        boolean found=false;
        for(int i=0;i<lines.size();i++){
            if(Math.abs(lines.get(i)-line)<delta){
                counts.set(i, counts.get(i)+1);
                found=true;
            }
        }
        if(found==false){

        }
    }

    double getLine(int[] p0,int[] p1){
        if(p0[0]==p1[0])return Double.POSITIVE_INFINITY;
        else{
            return (double)(p1[1]-p0[1])/(p1[0]-p0[0]);
        }
    }
}