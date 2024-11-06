
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void testInsert() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(1, heap.peek());
    }    
   
    
    @Test
    void testInsertOverflow() {
        MinHeap heap = new MinHeap(2);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(3, heap.peek()); 
    }

    @Test
    void testInsertWorstCase() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        assertEquals(1, heap.peek()); 
    }

    @Test
    void testDelete() {
        MinHeap heap = new MinHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.delete();
        assertEquals(2, heap.peek()); 
    }

    @Test
    void testOverflowDelete() {
        MinHeap heap = new MinHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.delete();
        heap.delete();
        heap.delete();
        assertEquals(0, heap.peek()); 
    }

    @Test
    void testFullDelete() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        assertEquals(0, heap.peek()); 
    }

    @Test
    public void testSize() {
        MinHeap minHeap = new MinHeap(10);
        assertEquals(0, minHeap.size());
        minHeap.insert(5);
        assertEquals(1, minHeap.size());
        minHeap.insert(10);
        assertEquals(2, minHeap.size());
        minHeap.delete();
        assertEquals(1, minHeap.size());
    }

    @Test
    public void testIsEmpty() {
        MinHeap minHeap = new MinHeap(10);
        assertTrue(minHeap.isEmpty());
        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
        minHeap.delete();
        assertTrue(minHeap.isEmpty());
    }

    @Test
    public void testInsertExceed() {
        MinHeap minHeap = new MinHeap(10);
        for (int i = 1; i <= 10; i++) {
            minHeap.insert(i);
        }
        assertEquals(10, minHeap.size());
        minHeap.insert(11); 
        assertEquals(10, minHeap.size()); 
    }

    @Test
    public void testHeapSort() {
        int[] unsortedArray = {5, 3, 8, 1, 2};
        int[] sortedArray = MinHeap.heapSort(unsortedArray);
        assertArrayEquals(new int[] {1, 2, 3, 5, 8}, sortedArray); 
    }

    @Test
    public void testHeapAfterManyInsert() {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(25);
        assertEquals(5, minHeap.peek()); 
    }

    @Test
    void testInsertDup() {
        MinHeap heap = new MinHeap(10);
        heap.insert(5);
        heap.insert(5);
        heap.insert(5);
        assertEquals(5, heap.peek());
        assertEquals(3, heap.size()); 
    }

    @Test
    void testDeleteUntilEmpty() {
        MinHeap heap = new MinHeap(5);
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
        MinHeap heap = new MinHeap(5);
        heap.insert(10);
        heap.insert(20);
        heap.delete(); 
        heap.insert(15);
        assertEquals(15, heap.peek()); 
    }

    @Test
    void testInsertLarge() {
        MinHeap heap = new MinHeap(5);
        heap.insert(Integer.MAX_VALUE);
        heap.insert(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, heap.peek()); 
    }

    @Test
    void testInsertNeg() {
        MinHeap heap = new MinHeap(5);
        heap.insert(-1);
        heap.insert(-2);
        heap.insert(-3);
        assertEquals(-3, heap.peek()); 
    }

    @Test
    void testHeapSortWithNeg() {
        int[] unsortedArray = {-5, -3, -8, -1, -2};
        int[] sortedArray = MinHeap.heapSort(unsortedArray);
        assertArrayEquals(new int[] {-8, -5, -3, -2, -1}, sortedArray); 
    }

    @Test
    void testInsertAndDelete() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.delete(); 
        heap.insert(4);
        assertEquals(4, heap.peek()); 
        heap.delete(); 
        assertEquals(5, heap.peek());
    }
}

