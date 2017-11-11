package Array;

import java.util.Scanner;

public class LeftRotation {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int n = 3;
        int size = arr.length;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < size; i++) {
            if(n > i)
                arr[size - n + i] = in.nextInt();
            else
                arr[i - n] = in.nextInt();
        }

        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
