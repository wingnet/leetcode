package TopInterviewQuestions.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FindOrder {
    HashSet<Integer> marked=new HashSet<>();
    HashSet<Integer> onStack=new HashSet<>();
    LinkedList<Integer> visited=new LinkedList<>();

    HashMap<Integer,HashSet<Integer>> pres=new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int[] pair:prerequisites){

            if(pres.containsKey(pair[0])){
                pres.get(pair[0]).add(pair[1]);
            }
            else {
                HashSet<Integer> set=new HashSet<>();
                set.add(pair[1]);
                pres.put(pair[0],set);
            }
        }

        for(int i=0;i<numCourses;i++){
            if(DFS(i)==false)return new int[0];
        }

        int[] result=new int[visited.size()];
        for(int i=0;i<result.length;i++){
            result[i]=visited.pollFirst();
        }
        return result;
    }

    boolean DFS(int course){
        if(marked.contains(course))return true;

        marked.add(course);


        if(pres.containsKey(course)==false){
            visited.addLast(course);
            return true;
        }
        onStack.add(course);

        HashSet<Integer> set=pres.get(course);
        for(int pre:set){
            if(onStack.contains(pre))return false;
            if(DFS(pre)==false)return false;
        }

        onStack.remove(course);

        visited.addLast(course);
        return true;
    }
}
