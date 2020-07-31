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

        return check(coins.length-1,amount);
    }

    int check(int coinIndex,int remain){
        //if(coinIndex<0||remain<0)return -1;
        IndexRemain key=new IndexRemain(coinIndex, remain);
        if(history.containsKey(key))return history.get(key);
        
        int curCoin=coins[coinIndex];
        int number=remain/curCoin;
        if(remain%curCoin==0){
            history.put(key, number);
            return number;
        }


        if(coinIndex==0)return -1;

        int minNumber=Integer.MAX_VALUE;

        for(int i=number;i>=0;i--){
            int result=check(coinIndex-1, remain-i*curCoin);
            if(result!=-1){
                minNumber=Math.min(minNumber, result+i);
            }
        }

        minNumber=minNumber==Integer.MAX_VALUE?-1:minNumber;

        history.put(key, minNumber);

        return minNumber;
    }
}