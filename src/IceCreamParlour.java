import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCreamParlour {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            for(int a_i=0; a_i < n; a_i++){
                int num = in.nextInt();
                // https://stackoverflow.com/questions/4157972/how-to-update-a-value-given-a-key-in-a-java-hashmap
                //map.computeIfPresent(num, (k, v) -> map.put(-1 * k,a_i+1));
                map.putIfAbsent(num,a_i+1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                int key = entry.getKey();
                int secKey = m - key;
                //int value = entry.getValue();
                if(key == secKey) secKey = -1 * key;
                if(map.containsKey(key) && map.containsKey(secKey))
                {
                    System.out.println(map.get(key) + " " + map.get(secKey));
                    break;
                }
            }
            map.clear();
        }
    }
}
