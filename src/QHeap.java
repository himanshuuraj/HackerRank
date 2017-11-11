import java.io.*;
import java.util.*;

public class QHeap {
    public static class MinHeap {
        private long[] Heap;
        private int size;
        private int maxsize;

        private static final int FRONT = 1;

        public MinHeap(int maxsize)
        {
            this.maxsize = maxsize;
            this.size = 0;
            Heap = new long[this.maxsize + 1];
            Heap[0] = Integer.MIN_VALUE;
        }

        private int parent(int pos)
        {
            return pos / 2;
        }

        public long getMinValue(){
            return Heap[1];
        }

        private int leftChild(int pos)
        {
            return (2 * pos);
        }

        private int rightChild(int pos)
        {
            return (2 * pos) + 1;
        }

        private boolean isLeaf(int pos)
        {
            if (2 * pos >=  (size )  &&  pos <= size)
            {
                return true;
            }
            return false;
        }

        private void swap(int fpos, int spos)
        {
            long tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }

        private void minHeapify(int pos)
        {
            if (!isLeaf(pos))
            {
                if ( Heap[pos] > Heap[leftChild(pos)]  || Heap[pos] > Heap[rightChild(pos)])
                {
                    if (Heap[leftChild(pos)] < Heap[rightChild(pos)])
                    {
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    }else
                    {
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
            }
        }

        public void insert(long element)
        {
            Heap[++size] = element;
            int current = size;

            while (Heap[current] < Heap[parent(current)])
            {
                swap(current,parent(current));
                current = parent(current);
            }
        }

        public void print()
        {
            for (int i = 1; i <= size / 2; i++ )
            {
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                        + " RIGHT CHILD :" + Heap[2 * i  + 1]);
                System.out.println();
            }
        }

        private void delete(int num){
            int pos = search(num);
            if(pos == -1)
                return;
            Heap[pos] = Heap[size];
            Heap[size] = 0;
            size--;
            minHeapify(pos);
        }

        public int search(long num){
            int tempSize = size;
            if(tempSize == 1)
                tempSize = 2;
            for (int i = 1; i <= tempSize / 2; i++ )
            {
                if(Heap[i] == num)
                    return i;
                if(Heap[2 * i] == num)
                    return 2 * i;
                if(Heap[2 * i + 1] == num)
                    return 2 * i + 1;
            }
            return -1;
        }

        public void minHeap()
        {
            for (int pos = (size / 2); pos >= 1 ; pos--)
            {
                minHeapify(pos);
            }
        }

        public long remove()
        {
            long popped = Heap[FRONT];
            Heap[FRONT] = Heap[size--];
            minHeapify(FRONT);
            return popped;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap minheap = new MinHeap(100000);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++){
            int a = sc.nextInt();
            int b;
            switch(a){
                case 1 :
                    b = sc.nextInt();
                    minheap.insert(b);
                    break;
                case 2 :
                    b = sc.nextInt();
                    minheap.delete(b);
                    break;
                case 3 :
                    System.out.println(minheap.getMinValue());
                    break;
            }
        }
    }
}
