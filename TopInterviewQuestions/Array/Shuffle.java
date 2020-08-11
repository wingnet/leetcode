package TopInterviewQuestions.Array;

import java.util.Random;

public class Shuffle {
    int[] nums;
    Random rand=new Random();
    public Shuffle(int[] nums) {
        this.nums=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result=nums.clone();

        for(int i=result.length-1;i>=0;i--){
            int index=rand.nextInt(i+1);
            int tmp=result[index];
            result[index]=result[i];
            result[i]=tmp;
        }
        return result;
    }
}