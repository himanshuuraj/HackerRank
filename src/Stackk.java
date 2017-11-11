import java.util.Scanner;
import java.util.Stack;

public class Stackk {
    static class StackNode{
        int data;
        int sum;
        public StackNode(int data,int sum){
            this.data = data;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];

            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            Stack<StackNode> stack1 = new Stack();
            int sum = 0;
            for (int h1_i = n - 1; h1_i >= 0; h1_i--) {
                sum += a[h1_i];
                stack1.push(new StackNode(a[h1_i], sum));
            }

            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            Stack<StackNode> stack2 = new Stack();
            sum = 0;
            for (int h1_i = m - 1; h1_i >= 0; h1_i--) {
                sum += b[h1_i];
                stack2.push(new StackNode(b[h1_i], sum));
            }

//            int count = 0;
//            while(stack1.peek().sum > x && stack2.peek().sum > x){
//                int temp = count;
//                if(stack1.peek().sum > stack2.peek().sum && stack1.peek().sum > x){
//                    stack1.pop();
//                    count++;
//                }
//                else if(stack2.peek().sum > stack1.peek().sum && stack2.peek().sum > x){
//                    stack2.pop();
//                    count++;
//                }
//                else if(stack1.peek().sum > x){
//                    stack1.pop();
//                    count++;
//                }
//                else if(stack2.peek().sum > 0){
//                    stack2.pop();
//                    count++;
//                }
//                if(temp == count)
//                    break;
//            }
//
//            System.out.println(count);

            int count = 0;
            while(!stack1.isEmpty() && stack1.peek().sum > x){
                stack1.pop();
                count++;
            }
            count = count < 0 ? 0 : --count;
            while(!stack2.isEmpty() && stack2.peek().sum > x){
                stack2.pop();
                count++;
            }
            count = count < 0 ? 0 : --count;
            System.out.println(count);
            // your code goes here
        }
    }
}
