import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        Arrays.sort(coins);

        String key = coins[0] + "";
        for(int i=1; i < m; i++){
            key += ","+coins[i];
        }

        System.out.println(getCombinations(n, coins, key));
    }

    static HashMap<String, Long> h = new HashMap();

    public static long getCombinations(int total, int coins[], String key){
        long result = 0;

        if(coins.length == 0)
            return 0;

        if(coins.length == 1){
            if(total % coins[0] == 0)
                return 1;
            else
                return 0;
        }

        int value = coins[0];

        if(total < value) {
            return 0;
        }

        if(total == value) {
            return 1;
        }

        Long a = h.get(total+"_"+key);
        if(a != null)
            return a.longValue();

        int origTotal = total;

        String subArrayKey = key.substring(key.indexOf(',')+1);
        int[] subArray = Arrays.copyOfRange(coins, 1, coins.length);

        do{
            result += getCombinations(total, subArray, subArrayKey);
            total -= value;
        }while(total > value);

        if(total == value)
            result++;

        h.put(origTotal+"_"+key,Long.valueOf(result));

        return result;
    }
}