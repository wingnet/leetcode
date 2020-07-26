package TopInterviewQuestions.HashMapping;

import java.util.ArrayList;
import java.util.HashMap;

class RandomizedSet {

    ArrayList<Integer> index2Num=new ArrayList<>();
    HashMap<Integer,Integer> num2index=new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(num2index.containsKey(val))return false;
        index2Num.add(val);
        num2index.put(val,index2Num.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(num2index.containsKey(val)){
            int index=num2index.get(val);
            int lastIndex=index2Num.size()-1;
            if(index<lastIndex){
                int lastValue=index2Num.get(lastIndex);
                index2Num.set(index, lastValue);
                index2Num.remove(lastIndex);
                num2index.put(lastValue,index);
                num2index.remove(val);
            }
            else{
                index2Num.remove(index);
                num2index.remove(val);
            }
            return true;
        }
        else return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(index2Num.size()==0)return -1;
        int randomIndex=(int)(Math.random()*index2Num.size());
        return index2Num.get(randomIndex);
    }
}