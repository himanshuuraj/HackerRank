import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigSorting {

    static class Checker implements Comparator {

        public int compare(Object obj1,Object obj2){
            String s1 = (String) obj1;
            String s2 = (String) obj2;

            if(s1.length() > s2.length())
                return 1;
            else if(s1.length() < s2.length())
                return -1;
            else{
                if(s1.compareTo(s2) > 0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Checker checker = new Checker();
        // your code goes here
        Arrays.sort(unsorted, checker);
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            System.out.println(unsorted[unsorted_i]);
        }

    }
}
