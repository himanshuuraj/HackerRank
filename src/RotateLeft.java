
import java.io.*;
import java.util.*;

public class RotateLeft {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = 6;
        in.nextInt();
        Integer a[] = new Integer[n];//{1,2,3,4,5,6};
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //Integer[] inputBoxed = ArrayUtils.toObject(input);
        List<Integer> list = new ArrayList();
        for(int index = 0; index < k; index++){
            list.add(a[index]);
        }
        for(int index = k,i = 0; index < n; index++,i++){
            a[i] = a[index];
        }
        for(int index = n-k,i=0; index < n;index++,i++){
            a[index] = (Integer)list.get(i);
        }
        Arrays.asList(a).forEach(System.out::println);
    }
}