import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RevList {

    static class StackNode{
        String data;
        public StackNode(String data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Stack<StackNode> stack = new Stack();
        String s = "";
        int b;
        for(int i = 0; i < t; i++){
            int a = sc.nextInt();
            switch(a){
                case 1:
                    String b1 = sc.next();
                    s += b1;
                    stack.add(new StackNode(s));
                    break;
                case 2:
                    b = sc.nextInt();
                    s = s.substring(0,s.length()-b);
                    stack.add(new StackNode(s));
                    break;
                case 3:
                    b = sc.nextInt();
                    char c = s.charAt(b-1);
                    System.out.println(c);
                    break;
                case 4:
                    stack.pop();
                    s = stack.isEmpty() ? "" : stack.peek().data;
                    break;
            }
        }
    }
}
