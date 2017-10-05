package dataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {1,2,3};
        Arrays.sort(coins);
        int n = 4;
        int a[] = new int[n+1];
        a[0] = 1;
        for(int i = 0; i<a.length; i++)
            a[i] = 1;
        for(int i = 1; i <= n;i++){
            if(i == 1)
                a[i] = 1;
            else{
                int max = 0;
                Set<Integer> hs = new HashSet<Integer>();
                for(int j = 0; j < coins.length;j++){
                    if(coins[j] > i)
                        break;
                    else{
                        //System.out.println(coins[j] + "  " + (i-coins[j]));
                        //if(max < a[coins[j]]*a[i-coins[j]])

                        if(!hs.contains(coins[j])) {
                            System.out.println(coins[j] + "  " + (i-coins[j]));
                            max += a[coins[j]] * a[i - coins[j]];
                        }
                        hs.add(new Integer(i-coins[j]));
                    }
                }
                a[i] = max;
                hs.clear();
            }
            System.out.println("ttttt---------------ttttttt");
        }
        for(int i = 0; i<a.length; i++)
            System.out.println(a[i]);
    }
}
