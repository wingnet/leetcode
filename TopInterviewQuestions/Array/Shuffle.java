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
        int indexRandom=result.length-1;
        for(int i=0;i<nums.length;i++){
            int index=rand.nextInt(indexRandom+1);
            int tmp=result[index];
            result[index]=result[indexRandom];
            result[indexRandom]=tmp;
            indexRandom--;
        }
        return result;
    }
}