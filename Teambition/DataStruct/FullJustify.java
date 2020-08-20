package Teambition.DataStruct;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> output=new ArrayList<>();

        
        int count=0;
        int firstIdx=0;
        for (int i = 0; i < words.length; i++) {
            if(count==0)count+=words[i].length();
            else count+=words[i].length()+1;

            if(count>maxWidth){
                output.add(buildALine(words, maxWidth, firstIdx, i));
                firstIdx=i;
                count=words[i].length();
            }
        }


        StringBuilder sb=new StringBuilder();
        for(int i=firstIdx;i<words.length;i++){
            if(i>firstIdx){
                sb.append(' ');
                
            }
            sb.append(words[i]);
        }
        appendSpaces(sb, maxWidth-sb.length());
        output.add(sb.toString());

        
        return output;
    }

    private String buildALine(String[] words, int maxWidth, int firstIdx, int endIdx) {
        StringBuilder sb=new StringBuilder();
        int charLen=0;
        for(int j=firstIdx;j<endIdx;j++){
            charLen+=words[j].length();
        }

        int numSpace=maxWidth-charLen;
        int numGap=endIdx-firstIdx-1;
        int base=0;
        int remain=0;
        if(numGap>0){
            base=numSpace/numGap;
            remain=numSpace%numGap;
        }

        for(int j=firstIdx;j<endIdx;j++){

            if(j>firstIdx){
                if(remain>0){
                    appendSpaces(sb, base+1);
                    remain--;
                }
                else{
                    appendSpaces(sb, base);
                }
            }
            sb.append(words[j]);
        }
        appendSpaces(sb, maxWidth-sb.length());
        return sb.toString();
    }

    private void appendSpaces(StringBuilder sb, int num) {
        for(int k=0;k<num;k++)sb.append(' ');
    }
}