public class MaxHeap {
    private long[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new long[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    public long getMaxValue(){
        return Heap[1];
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if(pos == 1 && size > pos)
            return false;

        if (2 * pos >=  (size )  &&  pos <= size)
        {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        long tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(long element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public long remove() {
        long popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }

    public void delete(int num){
        int pos = search(num);
        if(pos == -1)
            return;
        Heap[pos] = Heap[size];
        Heap[size] = 0;
        size--;
        maxHeapify(pos);
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

    public static void main(String...arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.delete(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
        System.out.println(maxHeap.getMaxValue());
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }
}