package day13.solutions.packets;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ValueComparatorTest {

    @Test
    public void testDiffLengthLists() {
        
        Packet p1 = new PacketParser().parsePacket("[1,1]");
        Packet p2 = new PacketParser().parsePacket("[1]");
        
        ValueComparator comparator = new ValueComparator();
        
        assert(comparator.compare(p1, p2) > 0);
    }
    
    @Test
    public void testNaturalOrderAscending() {
        
        Packet p1 = new PacketParser().parsePacket("[1,1]");
        Packet p2 = new PacketParser().parsePacket("[1]");
        
        
        List<ListValue> collection = new ArrayList<>();
        collection.add(p1);
        collection.add(p2);
        
        Collections.sort(collection, new ValueComparator());
        
        assertSame(p2, collection.get(0));
        assertSame(p1, collection.get(1));
    }
    
    @Test
    public void testPair2() {
        Packet p1 = new PacketParser().parsePacket("[[1],[2,3,4]]");
        Packet p2 = new PacketParser().parsePacket("[[1],4]");
        
        assertTrue(new ValueComparator().compare(p1, p2) < 0);
    }
    
    @Test
    public void testPair3() {
        Packet p1 = new PacketParser().parsePacket("[9]");
        Packet p2 = new PacketParser().parsePacket("[[8,7,6]]");
        
        assertTrue(new ValueComparator().compare(p1, p2) > 0);
    }
    
    @Test
    public void testPair5() {
        
        Packet p1 = new PacketParser().parsePacket("[7,7,7,7]");
        Packet p2 = new PacketParser().parsePacket("[7,7,7,6]");
        
        ValueComparator comparator = new ValueComparator();
        assertTrue(comparator.compare(p1, p2) > 0);
    }
    
    @Test
    public void testRealPair3() {
        
        Packet p1 = new PacketParser().parsePacket("[[[4,6,9,3,1],4,[3],[2,4,[6,10]],6],[]]");
        Packet p2 = new PacketParser().parsePacket("[[4,8],[[],6],[3,4]]");

        ValueComparator comparator = new ValueComparator();
        comparator.compare(p1, p2);
    }
    
    @Test
    public void testRealPair31() {
        Packet p1 = new PacketParser().parsePacket("[[8],[[2,7,2,[0,3,8]],[[6,3,8],3,[0],[3,6,1,4,3],6],10,6,[0]],[7],[[],[[],2,[0]]],[4,9,[[6,7,6]],7]]");
        Packet p2 = new PacketParser().parsePacket("[[[[8]]],[[2,[3,4,0,1,6],10,[8],[]],[[7,9],4,10],[[6,8],[],6,[],[5,7,6]],[[6,7,10,5,2]],3],[2,3,2,[[10]]],[8,2,[9,8,[1,0,2]]]]");
        
        ValueComparator comparator = new ValueComparator();
        comparator.compare(p1, p2);
    }
}
