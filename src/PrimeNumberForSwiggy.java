import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrimeNumberForSwiggy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String N = br.readLine();

        String out_ = PrimeDigitNumber(N);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static int checkPrime(char c){
        switch(c){
            case '2' : case '3' : case '5': case '7': return 1;
            default : return 0;
        }
    }
    static String switchNumber(char n){
        switch(n){
            case '9': case '8': case '7': return "7";
            case '6': case '5': return "5";
            case '4': case '3': return "3";
            case '2': return "2";
            case '1': return "0";
            default: return "1";
        }
    }
    static String PrimeDigitNumber(String N){
        // Write your code here    8990
        Integer n = Integer.parseInt(N);
        int len = N.length();
        String s = "";
        int flag = 0;
        for(int i = 0; i < len;i++){
            if(flag == 1){
                s += "7";
            }
            else{
                if(i != 0 && (N.charAt(i) == '1' || N.charAt(i) == '0')){
                    s = s.substring(0,s.length()-1);
                    int t = Integer.parseInt(String.valueOf(N.charAt(i-1)));
                    t--;
                    s += switchNumber(Integer.toString(t).charAt(0));
                    s += "7";
                }else {
                    if (checkPrime(N.charAt(i)) == 0) {
                        s += switchNumber(N.charAt(i));
                        flag = 1;
                    } else
                        s += N.charAt(i);
                }
            }
        }
        if(s.charAt(0) == '0')
            s = s.substring(1,s.length());
        return s;
    }
}
