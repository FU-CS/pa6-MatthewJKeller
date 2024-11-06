package pa6;

public class MinHeap implements Heap {
    int[] data;
    int size;
    int capacity;

    public MinHeap(int capacity){
        this.data = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    
    public void insert(int value){
        if (this.size < this.capacity) {
           data[size] = value;
           size++;
           int i = size - 1;       
           while ((i > 0) && (data[i] < data[(i-1)/2])) {
                int temp = data[(i-1)/ 2];
                data[(i-1)/ 2] = data[i];
                data[i] = temp;
                i = (i-1)/ 2;
            }
        }
    }

    public int delete() {
        if (size > 0) {
            int removed =data[0];
            data[0] = data[size-1];
            size--;
            heapify(0); 
            return removed;
        } 
        else return 0;
    }
    
    private void heapify(int i) {
        int smallest = i;
        if (2*i+1 < size && data[2*i+1] < data[smallest]) {
            smallest = 2*i+1;
        }
        if (2*i+2 < size && data[2*i+2] < data[smallest]) {
            smallest = 2*i+2;
        }
        if (smallest != i) {
            int temp = data[i];
            data[i] = data[smallest];
            data[smallest]= temp;
            heapify(smallest); 
        }
    }
    
    public int peek(){
        if (size != 0) {
            return data[0];
        }
        else{
            return 0;
        }
    }

    public int size(){
        return size;
    }
   
    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        for (int i = 0; i< size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    static int[] heapSort(int[] array){
        MinHeap newData = new MinHeap(array.length);
        
        for (int i = 0; i < array.length; i++) {
            newData.insert(array[i]);
        }
        
        int[] sortedArray = new int[array.length];
  
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = newData.delete();
        }
        
        return sortedArray;
    }
}
