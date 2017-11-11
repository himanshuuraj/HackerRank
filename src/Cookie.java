import java.io.*;
import java.util.*;

public class Cookie {

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
            if(pos == 1 && size > pos)
                return false;

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
            if(size == 1){
                long temp = Heap[FRONT];
                Heap[FRONT] = 0;
                size--;
                return temp;
            }
            long popped = Heap[FRONT];
            Heap[FRONT] = Heap[size--];
            minHeapify(FRONT);
            Heap[size+1] = 0;
            return popped;
        }

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        MinHeap minheap;
        Scanner sc = new Scanner(System.in);
        int step = 0;
        int n = sc.nextInt();
        int reqNumber = sc.nextInt();
        minheap = new MinHeap(n);
        for(int i = 0; i < n; i++){
            minheap.insert(sc.nextInt());
        }
        long cookie = minheap.remove();
        n--;
        while(cookie < reqNumber && n > 0){
            step++;
            long c = minheap.remove();
            n--;
            long temp;
            if(c > cookie){
                temp = c;
                c = cookie;
                cookie = temp;
            }
            temp = 1 * c + 2 * cookie;
            minheap.insert(temp);
            n++;
            cookie = minheap.remove();
            n--;
        }
        System.out.println(cookie < reqNumber ? -1 : step);
    }
}