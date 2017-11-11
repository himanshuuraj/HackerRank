package Array;
import java.io.*;
import java.util.*;

public class DynamicArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int lastAnswer = 0;
        int n = sc.nextInt();
        int t = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <n; i++)
            list.add(new ArrayList());

        for(int i = 0; i < t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a ==  1){
                int index = (b ^ lastAnswer) % n;
                list.get(index).add(c);
            }else if(a == 2){
                int index = (b ^ lastAnswer) % n;
                lastAnswer = list.get(index).get(c);
                System.out.println(lastAnswer);
            }
        }
    }
}