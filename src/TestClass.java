import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String N = br.readLine();

        String out_ = PrimeDigitNumber(N);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int checkPrime(int n){
        switch(n){
            case 2: case 3: case 5: case 7: return 1;
            default : return 0;
        }
    }
    static String PrimeDigitNumber(String N){
        // Write your code here
        Integer n = Integer.parseInt(N);
        Integer m = 1;
        for(int i = n; i >=1; i--) {
            m = i;
            while (m > 0) {
                if(checkPrime(m%10) == 0) break;
                m /= 10;
            }
            if(m == 0) {
                //System.out.println(m);
                m = i;
                break;
            }
        }
        return m.toString();
    }
}