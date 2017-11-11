import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PoisonousPlant {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        // 6 5 8 4 7 10 9
        Stack<Stack> container = new Stack();
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MAX_VALUE;
        for(int index = n - 1; index >= 0; index--){
            int t = p[index];
            if(t < max){
                if(index != n-1)
                    container.push(stack);
                stack = new Stack<>();
                stack.push(t);
            }
            else if(t >= max){
                stack.push(t);
            }
            max = t;
        }

        if(!stack.isEmpty())
            container.push(stack);

        if(container.size() == 1)
            return;


        stack = container.pop();
        max = stack.firstElement();
        int result = 0;
        int count = 0;
        do{
            Stack<Integer> st = container.pop();
            int temp = st.firstElement();
            count = 0;
            while(!st.isEmpty() && max < st.peek()){
                count++;
                st.pop();
            }
            result = result > count ? result : count;
            stack = st;
            max = temp;
        }while(!container.isEmpty());

        System.out.println(result);
        in.close();
    }
}
