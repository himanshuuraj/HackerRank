package Array;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).collect(Collectors.toList());
        IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).mapToLong(q -> strings.parallelStream().filter(q::equals).count()).forEach(System.out::println);
    }
}
