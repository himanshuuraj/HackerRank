import java.util.Scanner;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head = Reverse(head);

        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static class Node{
        int data;
        Node next = null;
        public Node(int data){
            this.data = data;
        }
    }

    static Node Reverse(Node head) {
        if(head != null || head.next != null){
            Node second = head;
            Node first = head.next;
            if(first.next == null){
                first.next = second;
            }else{
                Node curr = first.next;
                second.next = null;
                while(curr != null){
                    if(curr.next == null){
                        curr.next = first;
                        first.next = second;
                        head = curr;
                        break;
                    }
                    first.next = second;
                    second = first;
                    first = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}
