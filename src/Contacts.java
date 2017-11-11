import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Contacts {

    static class TrieNode {

        private char value;
        private HashMap<Character,TrieNode> children;
        private boolean bIsEnd;
        private int noOfNodes;

        public TrieNode(char ch)  {
            value = ch;
            children = new HashMap<>();
            bIsEnd = false;
        }
        public HashMap<Character,TrieNode> getChildren() {   return children;  }
        public char getValue()                           {   return value;     }
        public void setIsEnd(boolean val)                {   bIsEnd = val;     }
        public boolean isEnd()                           {   return bIsEnd;    }
        public void setNoOfNodes(int n){
            this.noOfNodes = n;
        }
        public int getNoOfNodes(){
            return noOfNodes;
        }
        public void increaseNoOfNodes(){
            noOfNodes++ ;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        TrieNode root = new TrieNode('0');
        //TrieNode crawl = root;
        while(t != 0){
            String a = sc.next();
            String b = sc.next();
            if("add".equals(a)){
                TrieNode crawl = root;
                for(int i = 0; i < b.length(); i++){
                    Map<Character,TrieNode> map = crawl.getChildren();
                    char ch = b.charAt(i);
                    if(map.containsKey(ch)){
                        crawl = map.get(ch);
                        crawl.increaseNoOfNodes();
                    }else{
                        TrieNode temp = new TrieNode(ch);
                        map.put(ch,temp);
                        temp.setNoOfNodes(1);
                        crawl = temp;
                    }
                }
                crawl.setIsEnd(true);
            }else if("find".equals(a)){
                TrieNode crawl = root;
                boolean flag = false;
                for(int i = 0; i < b.length(); i++){
                    Map<Character,TrieNode> map = crawl.getChildren();
                    char ch = b.charAt(i);
                    if(map.containsKey(ch)){
                        crawl = map.get(ch);
                    }else{
                        flag = true;
                        break;
                    }
                }
                if( flag ) //|| !crawl.isEnd())
                    System.out.println(0);
                else
                    System.out.println(crawl.getNoOfNodes());
            }
            t--;
        }
    }
}
