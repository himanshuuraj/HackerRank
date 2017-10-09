import java.io.*;
import java.util.*;

class BFS
{
    static int weight = 0;
    //static List<Node> stack = new ArrayList();
    static int[] output;
    /*public static class Node{
        int data;
        int weight;
        boolean visited;
        public Node(int data,int weight, boolean visited){
            this.data = data;
            this.weight = weight;
            this.visited = visited;
        }
    }*/

    public static class Graph {
        int size;  // This is basically the number of nodes
        Map<Integer,List<Integer>> edges = new HashMap();
        Stack<Integer> stack = new Stack();
        public Graph(int size) {
            this.size = size;
        }

        public void addEdge(int first, int second) {
            List al = new ArrayList();
            if(edges.containsKey(first)){
                al = edges.get(first);
                al.add(second);
            }else{
                al.add(second);
                edges.put(first,al);
            }
        }

        public void shortestReach(int startId) { // 0 indexed
            while(!stack.isEmpty()) {
                int startid = stack.pop();
                if(output[startid - 1] < 0) continue;
                output[startId - 1] = weight * 6;
                List<Integer> al = edges.get(startId);
                weight++;
                for (Integer i : al) {
                    output[startId - 1] = weight * 6;
                    if(!)
                    stack.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int size = 6;
        output = new int[size];
    }
}