package day15.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import day15.solutions.sensors.RowEncoding;
import day15.solutions.sensors.RunLengthEncoding;

public class RowEncodingTest {

    @Test
    public void testRemoveEqual() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(rle);
        assertEquals(0, row.count());
    }
    
    @Test
    public void testRemoveContains() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(8,10));
        assertEquals(4, row.count());
    }
    
    @Test
    public void testRemoveContained() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(4,14));
        assertEquals(0, row.count());
    }
    
    @Test
    public void testRemoveOverlapStart() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(4,9));
        assertEquals(3, row.count());
    }
    
    @Test
    public void testRemoveOverlapEnd() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(10,15));
        assertEquals(4, row.count());
    }
    
    @Test
    public void testRemoveUnrelated() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(2,4));
        assertEquals(7, row.count());
    }
    
    @Test
    public void testRemoveOverlapEqualStart() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(6,9));
        assertEquals(3, row.count());
    }
    
    @Test
    public void testRemoveOverlapEqualEnd() {
        RowEncoding row = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(6, 12);
        row.merge(rle);
        
        row.remove(new RunLengthEncoding(10,12));
        assertEquals(4, row.count());
    }
}
