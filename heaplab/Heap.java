package heaplab;
/* Thanyapoj Trikasemsak
 * 62130500214
 */
public class Heap {
    int[] heap;
    int size;

    public Heap(int maxNumberOfMembers) {
        heap = new int[maxNumberOfMembers];
        size = 0;
    }
    public Heap(){
        this(100);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size == heap.length;
    }
    public void enqueue(int newValue){
        if (!isFull()) {
            heap[size]=newValue;
            int indexOfNewValue = size;
            size++;
            int parentIndex =(int) Math.floor((indexOfNewValue-1)/2.0);
            while (indexOfNewValue > 0 && heap[parentIndex] < heap[indexOfNewValue]){
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[indexOfNewValue];
                heap[indexOfNewValue] = temp;
                indexOfNewValue = parentIndex;
                parentIndex = (int) Math.floor((indexOfNewValue-1)/2.0);
            }

        }else {
            System.out.println("The heap is full. Gomen :'(");
        }
    }
    public int dequeue(){
        int max = heap[0];
        heap[0] = heap[size-1];
        size--;
        int indexOfReplacingNode = 0;
        int leftChildOfReplacingNode = 2*indexOfReplacingNode+1;
        int rightChildOfReplacingNode = 2*indexOfReplacingNode+2;
        int swapIndex = 0;
        while (leftChildOfReplacingNode < size && heap[indexOfReplacingNode] < heap[leftChildOfReplacingNode]
               || (rightChildOfReplacingNode < size && heap[indexOfReplacingNode] < heap[rightChildOfReplacingNode])){
            if (leftChildOfReplacingNode == size-1) {
                swapIndex=leftChildOfReplacingNode;
            }else {
                if (heap[leftChildOfReplacingNode] > heap[rightChildOfReplacingNode]) {
                    swapIndex=leftChildOfReplacingNode;
                }else {
                    swapIndex=rightChildOfReplacingNode;
                }
            }
            int temp = heap[indexOfReplacingNode];
            heap[indexOfReplacingNode] = heap[swapIndex];
            heap[swapIndex] = temp;
            indexOfReplacingNode=swapIndex;
            leftChildOfReplacingNode = 2*indexOfReplacingNode+1;
            rightChildOfReplacingNode = 2*indexOfReplacingNode+2;
        }
        return max;
    }
}
