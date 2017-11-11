package Array;

import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        for(int i = 0; i < 10; i++)
            priorityQueue.add(i);
        //priorityQueue.forEach(System.out::println);
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
    }
}
