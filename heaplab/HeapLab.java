package heaplab;

public class HeapLab {
    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.enqueue(15); h.enqueue(20); h.enqueue(9); h.enqueue(99);
        h.enqueue(83); h.enqueue(22); h.enqueue(-100);h.enqueue(0);h.enqueue(66);

        for (int i = 0; i < h.size; i++) {
            System.out.print(h.heap[i]+" ");
        }
        h.enqueue(200);
        System.out.println("\n" +h.heap[0]);
        while (!h.isEmpty()){
            System.out.print(h.dequeue()+" ");
        }
    }
}
