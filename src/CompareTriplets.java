import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CompareTriplets {

    static String solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
        String pointsAlice = "";
        String pointsBob = "";
        pointsAlice = String.valueOf((a0>b0)?1:0) + String.valueOf((a1>b1)?1:0) + String.valueOf((a2>b2)?1:0) ;
        pointsBob = String.valueOf((a0<b0)?1:0) + String.valueOf((a1<b1)?1:0) + String.valueOf((a2<b2)?1:0) ;
        return pointsAlice + "" + pointsBob;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        String result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == '1')
                System.out.print(result.charAt(i));
        }
        System.out.println("");
    }
}