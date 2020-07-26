package TopInterviewQuestions.HeapStackQueue;

import java.util.LinkedList;

public class MedianFinder {

    boolean isTwoMid;
    public MedianFinder() {

    }
    LinkedList<Integer> buf=new LinkedList<>();
    public void addNum(int num) {
        if(buf.isEmpty()){
            buf.addLast(num);
        }
        else{
            if(isTwoMid==false){
                buf.addLast(num);

                isTwoMid=true;
            }
            else{
                buf.addLast(num);
                buf.removeFirst();
                isTwoMid=false;
            }
        }
    }
    
    public double findMedian() {
        if(isTwoMid)return (buf.get(0)+buf.get(1))/2.0;
        return buf.get(0);
    }
}