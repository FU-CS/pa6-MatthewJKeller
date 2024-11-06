
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

    @Test
    void testInsert() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(8, heap.peek());
    }

    @Test
    void testInsertOverflow() {
        MaxHeap heap = new MaxHeap(2);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(5, heap.peek());
    }

    @Test
    void testInsertWorstCase() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        assertEquals(5, heap.peek());
    }

    @Test
    void testDelete() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.delete();
        assertEquals(1, heap.peek());
    }
    @Test
    void testOverflowDelete() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        assertEquals(0, heap.peek());
    }
    @Test
    void testFullDelete() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        assertEquals(0, heap.peek());
}
    @Test
    public void testSize() {
        MaxHeap maxHeap = new MaxHeap(10);
        assertEquals(0, maxHeap.size());
        maxHeap.insert(5);
        assertEquals(1, maxHeap.size());
        maxHeap.insert(10);
        assertEquals(2, maxHeap.size());
        maxHeap.delete();
        assertEquals(1, maxHeap.size());
    }

    @Test
    public void testIsEmpty() {
        MaxHeap maxHeap = new MaxHeap(10);
        assertTrue(maxHeap.isEmpty());
        maxHeap.insert(10);
        assertFalse(maxHeap.isEmpty());
        maxHeap.delete();
        assertTrue(maxHeap.isEmpty());
    }

    @Test
    public void testInsertExceed() {
        MaxHeap maxHeap = new MaxHeap(10);
        for (int i = 1; i <= 10; i++) {
            maxHeap.insert(i);
        }
        assertEquals(10, maxHeap.size());
        maxHeap.insert(11); 
        assertEquals(10, maxHeap.size()); 
    }

    @Test
    public void testHeapSort() {
        int[] unsortedArray = {5, 3, 8, 1, 2};
          int[] sortedArray = MaxHeap.heapSort(unsortedArray);
        assertArrayEquals(new int[] {8, 5, 3, 2, 1}, sortedArray);
    }


    @Test
    public void testHeapAfterInsertions() {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(25);
        assertEquals(25, maxHeap.peek()); 
    }

    @Test
    void testInsertMultipleDup() {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(5);
        heap.insert(5);
        heap.insert(5);
        assertEquals(5, heap.peek()); 
        assertEquals(3, heap.size()); 
    }

    @Test
    void testDeleteUntilEmpty() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.delete();
        heap.delete();
        heap.delete();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testDeleteAndInsert() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.delete(); 
        heap.insert(15);
        assertEquals(15, heap.peek()); 

    }
    @Test
    void testInsertLarge() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(Integer.MAX_VALUE);
        heap.insert(Integer.MIN_VALUE);
        assertEquals(Integer.MAX_VALUE, heap.peek());
    }

    @Test
    void testInsertNeg() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(-1);
        heap.insert(-2);
        heap.insert(-3);
        assertEquals(-1, heap.peek()); 
    }

    @Test
    void testHeapSortWithNeg() {
        int[] unsortedArray = {-5, -3, -8, -1, -2};
        int[] sortedArray = MaxHeap.heapSort(unsortedArray);
        assertArrayEquals(new int[] {-1, -2, -3, -5, -8}, sortedArray);
    }

    @Test
    void testInsertAndDelete() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.delete(); 
        heap.insert(3);
        heap.insert(4);
        assertEquals(4, heap.peek()); 
        heap.delete(); 
        assertEquals(3, heap.peek());
    
}
}
    


