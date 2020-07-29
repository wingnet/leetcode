package TopInterviewQuestions.HeapStackQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    LinkedList<Integer> counters=new LinkedList<>();
    LinkedList<List<NestedInteger>> lists=new LinkedList<>();

    boolean _hasNext=false;
    int nextValue;
    public NestedIterator(List<NestedInteger> nestedList) {

        if(nestedList==null)_hasNext=false;
        else{
            lists.addLast(nestedList);
            counters.addLast(0);

            update();
        }
        
    }

    private void update() {
        while(lists.isEmpty()==false){
            List<NestedInteger> current=lists.getLast();
            int index=counters.getLast();
            if(index>=current.size()){
                lists.removeLast();
                counters.removeLast();
                if(counters.isEmpty()==false){
                    int temp=counters.pollLast();
                    counters.addLast(temp+1);
                }
            }
            else if(current.get(index).isInteger()){
                _hasNext=true;
                nextValue=current.get(index).getInteger();
                break;
            }
            else{
                lists.add(current.get(index).getList());
                counters.add(0);
            }
        }
        if(lists.isEmpty())_hasNext=false;
    }

    @Override
    public Integer next() {
        int result=nextValue;
        int tmp=counters.pollLast();
        counters.addLast(tmp+1);
        update();
        return result;
    }

    @Override
    public boolean hasNext() {
        return _hasNext;
    }
}