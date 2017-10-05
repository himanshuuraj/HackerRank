import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ransom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String str = in.next();
            map.computeIfPresent(str, (k,v) -> ++v);
            map.putIfAbsent(str, 1);
        }
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            String str = in.next();
            if(!map.containsKey(str) || (map.containsKey(str) && map.get(str) == 0)){
                System.out.println("No");
                return;
            }
            int t = map.get(str);
            t--;
            map.put(str,t);
        }
        System.out.println("Yes");
    }
}