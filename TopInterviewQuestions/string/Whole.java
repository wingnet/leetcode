package TopInterviewQuestions.string;


public class Whole {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }
            else if(Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        int halfLen=sb.length()/2;
        for(int i=0;i<halfLen;i++){
            if(sb.charAt(i)!=sb.charAt(sb.length()-1-i))return false;
        }
        return true;
    }

    
    public static void main(String[] args){
        String str="123".substring(0,0);
        System.out.println(str.length());
    }
}