import java.io.*;
import java.util.*;

public class TruckTour {

    static class Node{
        int petrol;
        int km;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int j = -1,i = 0;
        boolean flag = true;

        List<Node> list = new ArrayList();

        for(i = 0; i < testCases; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node node = new Node();
            node.petrol = a;
            node.km = b;
            list.add(node);
        }
        int petrol = 0; i = 0;

        while(j != i || !flag){
            if(!flag) flag = true;
            Node n = list.get(i);
            petrol += (n.petrol - n.km);
            if(petrol < 0){
                j = i;
                j++;
                petrol = 0;
                flag = false;
            }
            i++;
            if(i == list.size())
                i = 0;
        }
        System.out.println(++j);
    }
}