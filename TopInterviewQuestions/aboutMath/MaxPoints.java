package TopInterviewQuestions.aboutMath;

import java.util.HashMap;

public class MaxPoints {
    static class Fraction{
        int num0;
        int num1;
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Fraction){
                Fraction fraction=(Fraction)obj;
                return this.num0==fraction.num0 && this.num1==fraction.num1;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (""+num0+":"+num1).hashCode();
        }

        void init(int x,int y){
            if(y==0){
                num0=1;
                num1=0;
            }
            else if(x==0){
                num0=0;
                num1=1;
            }
            else {
                int gcd=Math.abs(gcd(x, y));
                if(y<0){
                    x=-x;
                    y=-y;
                }
                num0=x/gcd;
                num1=y/gcd;
            }
        }

        Fraction(int[] p0,int[] p1){
            init(p0[0]-p1[0], p0[1]-p1[1]);
        }

        int gcd(int a,int b){
            
            int tmp=a%b;
            while(tmp!=0){
                a=b;
                b=tmp;
                tmp=a%b;
            }
            return b;
        }
    }
    HashMap<Fraction,Integer> lines=new HashMap<>();

    public int maxPoints(int[][] points) {

        if(points.length<3)return points.length;
        int max=1;
        for(int i=0;i<points.length;i++){
            int[] p0=points[i];
            int dup=0;
            int localMax=1;
            lines.clear();
            for(int j=i+1;j<points.length;j++){
                int[] p1=points[j];
                if(p0[0]==p1[0] && p0[1]==p1[1])dup++;
                else{
                    
                    Fraction fraction=new Fraction(p0,p1);

                    int count=lines.getOrDefault(fraction,1)+1;
                    lines.put(fraction, count);
                    localMax=Math.max(localMax,count);
                }
            }
            max=Math.max(max, dup+localMax);
        }

        return max;
        
    }

    static int gcd(int a,int b){
        int tmp=a%b;
        while(tmp!=0){
            a=b;
            b=tmp;
            tmp=a%b;
        }
        return b;
    }

    public static void main(String[] args){
        System.out.println(gcd(12, 10));
        System.out.println(gcd(-12, 10));
        System.out.println(gcd(12, -10));
        System.out.println(gcd(10, 12));
        System.out.println(gcd(-10, 12));
        System.out.println(gcd(10, -12));
        System.out.println(gcd(0, -12));
        System.out.println(gcd(10, 0));
    }
}