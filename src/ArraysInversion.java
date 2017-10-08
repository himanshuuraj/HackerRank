import java.util.Scanner;

public class ArraysInversion {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int  i = 0;i < n;i++){
            a[n-1-i] = in.nextInt();
        }
        for(int  i = 0;i < n;i++){
            System.out.println(a[i]);
        }
    }
}
