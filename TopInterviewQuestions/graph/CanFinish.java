package TopInterviewQuestions.graph;

import java.util.*;

public class CanFinish {
    HashMap<Integer,HashSet<Integer>> relations=new HashMap<>();
    HashSet<Integer> marked =new HashSet<>();
    HashSet<Integer> onStack =new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int[] relation:prerequisites){
            if(relations.containsKey(relation[0])){
                relations.get(relation[0]).add(relation[1]);
            }
            else {
                HashSet<Integer> tmp=new HashSet<>();
                tmp.add(relation[1]);
                relations.put(relation[0],tmp);
            }
        }

        for(int i=0;i<numCourses;i++){

            if(DFS(i)==false)return false;

        }

        return true;
    }

    boolean DFS(int course){
        if(marked.contains(course))return true;

        marked.add(course);

        if(relations.containsKey(course)==false)return true;

        onStack.add(course);

        HashSet<Integer> pres=relations.get(course);
        for(int i:pres){
            if(onStack.contains(i))return false;
            if(DFS(i)==false)return false;
        }

        onStack.remove(course);
        return true;
    }
}
