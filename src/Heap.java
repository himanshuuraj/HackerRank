import java.util.ArrayList;
import java.util.List;

public class Heap<E> {
    String heapType;
    List<E> heap = new ArrayList<E>();
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>();
        heap.setHeapType("maxHeap");
        heap.insertIntoHeap(1);
        heap.insertIntoHeap(9);
        heap.insertIntoHeap(5);
        heap.insertIntoHeap(4);
        heap.insertIntoHeap(3);
        heap.insertIntoHeap(2);
    }
    public void setHeapType(String type){
        heapType = type;
    }
    public void insertIntoHeap(E n){
        heap.add(n);
        int size = heap.size();
        size--;
        if(size == 0) return;
        if("minHeap".equals(heapType)){
            int precedessor = (size-1)/2;
            while((Integer)heap.get(size) < (Integer)heap.get(precedessor)){
                Integer temp = (Integer)heap.get(size);
                heap.set(size,heap.get(precedessor));
                heap.set(precedessor,(E)temp);
                size = precedessor;
                precedessor = (size-1)/2;
            }
        }
        if("maxHeap".equals(heapType)){
            int precedessor = (size-1)/2;
            while((Integer)heap.get(size) > (Integer)heap.get(precedessor)){
                Integer temp = (Integer)heap.get(size);
                heap.set(size,heap.get(precedessor));
                heap.set(precedessor,(E)temp);
                size = precedessor;
                precedessor = (size-1)/2;
            }
        }
        System.out.println(heap);
    }
    public void deleteFromHeap(){

    }
}
