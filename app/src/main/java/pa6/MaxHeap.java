package pa6;

public class MaxHeap implements Heap {
    int[] data;
    int size;
    int capacity;

    public MaxHeap(int capacity){
        this.data = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    
    public void insert(int value){
        if (this.size < this.capacity) {
           data[size] = value;
           size++;
           int i=size-1;       
           while((data[i] > data[(i-1)/2]) && ((i-1)/2 >= 0)){
                int temp = data[(i-1)/2];
                data[(i-1)/2] = data[i];
                data[i] = temp;
                i = (i-1)/2;
            }
        }
    }

    public int delete() {
        if (size > 0) {
            int removed = data[0];
            data[0] = data[size - 1];
            size--;
            heapify(0); 
            return removed;
        } 
        else return 0;
    }
    
    private void heapify(int i) {
        int largest = i;
        if (2*i+1 < size && data[2*i+1] > data[largest]) {
            largest = 2*i+1;
        }
        if (2*i+2 < size && data[2*i+2] > data[largest]) {
            largest = 2*i+2;
        }
        if (largest != i) {
            int temp = data[i];
            data[i] = data[largest];
            data[largest] = temp;
            heapify(largest); 
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
        for(int i=0; i<size; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    static int[] heapSort(int[] array){
        MaxHeap newData = new MaxHeap(array.length);
        
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
