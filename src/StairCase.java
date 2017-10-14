import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class StairCase {
    public static int f(int n){
        switch(n){
            case 1: case 2: return n;
            case 3 : return 4;
            default : return f(n-1) + f(n-2) + f(n-3);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();

        for(int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i = 4; i <= n; ++i)
                dp[i] = dp[i-1] + dp[i-2] + dp[i - 3];

            System.out.println(dp[n]);
        }
    }
}
