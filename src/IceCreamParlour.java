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
                if(map.containsKey(num)){
                    map.put(-1 * num,a_i+1);
                }
                map.putIfAbsent(num,a_i+1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                int key = entry.getKey();
                if( key < 0) continue;
                int secKey = m - key;
                if(key == secKey) secKey = -1 * key;
                if(map.containsKey(key) && map.containsKey(secKey))
                {
                    int x = map.get(key);
                    int y = map.get(secKey);
                    if(x > y && y > 0) {
                        int temp = x;
                        x = y;
                        y = temp;
                    }
                    System.out.println(x + " " + y);
                    break;
                }
            }
            map.clear();
        }
    }

}
