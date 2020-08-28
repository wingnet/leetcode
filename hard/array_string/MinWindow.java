package hard.array_string;

import java.util.HashMap;

public class MinWindow {
    
    String s;
    String t;
    HashMap<Character,Integer> mapT=new HashMap<>();
    HashMap<Character,Integer> mapTmp=new HashMap<>();
    public String minWindow(String s, String t) {
        this.s=s;
        this.t=t;

        for (char ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0)+1);
        }

        
        int count=0;
        int start=-1;
        int end=-1;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(mapT.containsKey(ch)){

                if(start<0)start=i;
                int num=mapT.get(ch);
                int tmp=mapTmp.getOrDefault(ch, 0)+1;
                mapTmp.put(ch, tmp);
                if(tmp<=num)count++;
    
                if(count==t.length()){
                    end=i;
                    break;
                }
            }

        }

        if(end<0)return "";

        int resultStart=start;
        int resultEnd=end;

        while(true){
            while(start<s.length()){
                
                char chStart=s.charAt(start);

                if(decrese(chStart)<mapT.get(chStart)){
                    break;
                }
                
                start=getNext(start);
                
            }

            if(end-start<resultEnd-resultStart){
                resultStart=start;
                resultEnd=end;
            }

            char chDrop=s.charAt(start);
            start=getNext(start);
            end=getNext(end);
            while(end<s.length() && s.charAt(end)!=chDrop){
                
                increase(s.charAt(end));
                
                end=getNext(end);
            }
            
            if(end==s.length())return s.substring(resultStart, resultEnd+1);
            
            increase(chDrop);

        }

        //return s.substring(resultStart, resultEnd+1);
    }

    int decrese(char ch){
        int tmp=mapTmp.get(ch)-1;
        mapTmp.put(ch, tmp);
        return tmp;
    }

    int increase(char ch){
        int tmp=mapTmp.get(ch)+1;
        mapTmp.put(ch, tmp);
        return tmp;
    }

    int getNext(int start){
        int i = start+1;
        while ( i < s.length() && mapT.containsKey(s.charAt(i))==false) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        MinWindow solution=new MinWindow();
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(solution.minWindow(s, t));
    }
}