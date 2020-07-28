package TopInterviewQuestions.HeapStackQueue;

import java.util.LinkedList;

public class MaxSlidingWindow {
    int[] nums;

    LinkedList<Integer> deque=new LinkedList<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.nums=nums;
        int[] result=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            updateDesc(i);
        }

        result[0]=nums[deque.getFirst()];

        for(int i=k;i<nums.length;i++){
            if(deque.isEmpty()==false && deque.getFirst()==i-k){
                deque.removeFirst();
            }

            updateDesc(i);
            result[i-k+1]=nums[deque.getFirst()];
        }

        return result;
    }
    private void updateDesc(int i) {
        int current=nums[i];

        while(deque.isEmpty()==false && nums[deque.getLast()]<current){
            deque.removeLast();
        }

        deque.addLast(i);
    }
}