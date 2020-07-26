package TopInterviewQuestions.HeapStackQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> pq1stHalf=new PriorityQueue<>((x,y)->y-x);
    PriorityQueue<Integer> pq2ndHalf=new PriorityQueue<>();
    int count=0;

    public MedianFinder() {

    }
    LinkedList<Integer> buf=new LinkedList<>();
    public void addNum(int num) {
        count++;
        int num1st=(count+1)/2;
        
        if(count==1)pq1stHalf.add(num);
        else if(count==2){
            if(num<pq1stHalf.peek()){
                pq2ndHalf.add(pq1stHalf.poll());
                pq1stHalf.add(num);
            }
            else{
                pq2ndHalf.add(num);
            }
            
        }
        else{
            if(num1st>pq1stHalf.size()){
                if(num<=pq2ndHalf.peek())pq1stHalf.add(num);
                else{
                    pq2ndHalf.add(num);
                    pq1stHalf.add(pq2ndHalf.poll());
                }
            }
            else{
                if(num>=pq1stHalf.peek()){
                    pq2ndHalf.add(num);
                }
                else{
                    pq1stHalf.add(num);
                    pq2ndHalf.add(pq1stHalf.poll());
                }
            }
        }

        

    }
    
    public double findMedian() {
        if(count%2==1)return pq1stHalf.peek();
        return (pq1stHalf.peek()+pq2ndHalf.peek())/2.0;
    }
}