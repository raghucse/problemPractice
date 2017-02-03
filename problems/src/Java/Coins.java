package Java;

import java.util.Arrays;

/**
 * Created by raghu on 1/9/2017.
 */
class Counter{
    int count;
    Counter(int count)
    {
        this.count = count;
    }
}


public class Coins {

    static int count = 0;


    public static void main(String[] args) {
        int denom[] = {25,10,5,1};

        System.out.println(new Coins().ways(4,denom));
        System.out.println(new Coins().makeChange(4));
    }

    public int ways(int remCoin, int denom[])
    {
        if(remCoin < 0)
            return 0;

        if(remCoin == 0) {
            return 1;
        }

        int way = 0;
        for (int i: denom) {
            way += ways(remCoin-i, denom);
        }

        return way;
    }

    int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1; //last denom
         int denomAmount = denoms[index];
         int ways = 0;
         for (int i= 0; i * denomAmount <= amount; i++) {
             int amountRemaining = amount - i * denomAmount;
             ways+= makeChange(amountRemaining, denoms, index + 1);
             }
         return ways;
         }

    int makeChange(int n) {
         int[] denoms = {25,10,5,1};
         return makeChange(n, denoms, 0);
    }

}
