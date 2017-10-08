import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class BitManipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> map = new HashMap();
        for(int a_i=0; a_i < n; a_i++){
            int num = in.nextInt();
            map.computeIfPresent(num, (key, val) -> ++val);
            map.putIfAbsent(num,1);
        }
        map.forEach((id, val) -> {
            if(val == 1)
                System.out.println(id);
        });
    }
}
