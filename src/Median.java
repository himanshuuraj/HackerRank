import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Median {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if(a_i == 0){
                System.out.println((double)a[a_i]);
            } else {

                int value = a[a_i];

                int j = Math.abs(Arrays.binarySearch(a, 0, a_i, value) + 1);

                //Shifting array to one location right
                System.arraycopy(a, j, a, j+1, a_i-j);

                //Placing element at its correct location
                a[j] = value;


                j = a_i/2;
                if(a_i % 2 == 0){
                    System.out.println((double)a[j]);
                }
                else
                    System.out.println(((double)(a[j]+a[j+1])/2));
            }
        }
    }
}