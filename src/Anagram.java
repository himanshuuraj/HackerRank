import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Anagram {
    public static int numberNeeded(String first, String second) {
        int sum = 0;
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        for(int i = 0; i < first.length(); i++){
            map1.computeIfPresent(first.charAt(i), (key,value)-> value+=1);
            map1.putIfAbsent(first.charAt(i), 1);
        }
        for(int i = 0; i < second.length(); i++){
            map2.computeIfPresent(second.charAt(i), (key,value)-> value+=1);
            map2.putIfAbsent(second.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet())
        {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(!map2.containsKey(key)) sum += map1.get(key);
            else{
                sum += Math.abs(value - map2.get(key));
                map2.remove(key);
            }
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet())
        {
            sum += entry.getValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
