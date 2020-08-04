package TopInterviewQuestions.dp;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    int[] coins;
    int amount;
    HashMap<IndexRemain,Integer> history=new HashMap<>();
    static class IndexRemain{
        int index;
        int remain;
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof IndexRemain){
                IndexRemain indexRemain=(IndexRemain)obj;
                return index==indexRemain.index&&remain==indexRemain.remain;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (""+index+','+remain).hashCode();
        }

        IndexRemain(int index, int remain){
            this.index=index;
            this.remain=remain;
        }
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins=coins;
        this.amount=amount;

        check(coins.length-1,amount,0);
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }

    int minLen=Integer.MAX_VALUE;
    int check(int coinIndex,int remain,int curLen){
        if(curLen>=minLen)return Integer.MAX_VALUE;
        IndexRemain key=new IndexRemain(coinIndex, remain);
        if(history.containsKey(key)){
            int tmp=history.get(key);
            if(tmp<Integer.MAX_VALUE){
                minLen=Math.min(minLen,tmp+curLen);
            }
            return tmp;
        }
        
        int curCoin=coins[coinIndex];
        int number=remain/curCoin;
        if(remain%curCoin==0){
            history.put(key, number);
            minLen=Math.min(minLen,curLen+number);
            return number;
        }


        if(coinIndex==0){
            history.put(key,Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }

        int minNumber=Integer.MAX_VALUE;

        for(int i=number;i>=0;i--){
            int result=check(coinIndex-1, remain-i*curCoin,i+curLen);
            if(result!=Integer.MAX_VALUE){
                minNumber=Math.min(minNumber, result+i);
            }
        }

        history.put(key, minNumber);

        return minNumber;
    }

    public static void main(String[] args){
        CoinChange solution=new CoinChange();
        int[] coins={227,99,328,299,42,322};

        System.out.println(solution.coinChange(coins, 9847));
        //solution.history.put(new CoinChange.IndexRemain(1, 1),111);
        //solution.history.put(new CoinChange.IndexRemain(1, 1),222);
    }
}