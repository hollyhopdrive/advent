package day13.solutions.packets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PacketParserTest {

    @Test
    public void testParsePacket1() {
        final String line = "[1,1,3,1,1]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(5, data.size());
        
        assertEquals(new IntegerValue(1), data.get(0));
        assertEquals(new IntegerValue(1), data.get(1));
        assertEquals(new IntegerValue(3), data.get(2));
        assertEquals(new IntegerValue(1), data.get(3));
        assertEquals(new IntegerValue(1), data.get(4));
    }
    
    @Test
    public void testParsePacket2() {
        final String line = "[1,1,5,1,1]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(5, data.size());
        
        assertEquals(new IntegerValue(1), data.get(0));
        assertEquals(new IntegerValue(1), data.get(1));
        assertEquals(new IntegerValue(5), data.get(2));
        assertEquals(new IntegerValue(1), data.get(3));
        assertEquals(new IntegerValue(1), data.get(4));
    }
    
    @Test
    public void testParsePacket3() {
        final String line = "[[1],[2,3,4]]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(2, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(1));
        assertEquals(new ListValue(values1), data.get(0));
        
        List<Value> values2 = new ArrayList<>();
        values2.add(new IntegerValue(2));
        values2.add(new IntegerValue(3));
        values2.add(new IntegerValue(4));
        assertEquals(new ListValue(values2), data.get(1));
    }
    
    @Test
    public void testParsePacket4() {
        final String line = "[[1],4]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(2, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(1));
        assertEquals(new ListValue(values1), data.get(0));

        assertEquals(new IntegerValue(4), data.get(1));
    }
    
    @Test
    public void testParsePacket5() {
        final String line = "[9]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(1, data.size());
        
        assertEquals(new IntegerValue(9), data.get(0));
    }
    
    @Test
    public void testParsePacket6() {
        final String line = "[[8,7,6]]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(1, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(8));
        values1.add(new IntegerValue(7));
        values1.add(new IntegerValue(6));
        assertEquals(new ListValue(values1), data.get(0));
    }
    
    @Test
    public void testParsePacket7() {
        final String line = "[[4,4],4,4]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(3, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(4));
        values1.add(new IntegerValue(4));
        assertEquals(new ListValue(values1), data.get(0));

        assertEquals(new IntegerValue(4), data.get(1));
        assertEquals(new IntegerValue(4), data.get(2));
    }
    
    @Test
    public void testParsePacket8() {
        final String line = "[[4,4],4,4,4]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(4, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(4));
        values1.add(new IntegerValue(4));
        assertEquals(new ListValue(values1), data.get(0));

        assertEquals(new IntegerValue(4), data.get(1));
        assertEquals(new IntegerValue(4), data.get(2));
        assertEquals(new IntegerValue(4), data.get(2));
    }
    
    @Test
    public void testParsePacket11() {
        final String line = "[]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertTrue(data.isEmpty());
    }
    
    @Test
    public void testParsePacket13() {
        final String line = "[[[]]]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(1, data.size());
        
        List<Value> emptyInner = new ArrayList<>();
        ListValue inner = new ListValue(emptyInner);
        ListValue outer = new ListValue(Collections.singletonList(inner));
        
        assertEquals(outer, data.get(0));
    }
    
    @Test
    public void testParsePacket15() {
        final String line = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(4, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(5));
        values1.add(new IntegerValue(6));
        values1.add(new IntegerValue(7));
        ListValue lv1 = new ListValue(values1);
        
        List<Value> values2 = new ArrayList<>();
        values2.add(new IntegerValue(4));
        values2.add(lv1);
        ListValue lv2 = new ListValue(values2);

        List<Value> values3 = new ArrayList<>();
        values3.add(new IntegerValue(3));
        values3.add(lv2);
        ListValue lv3 = new ListValue(values3);
        
        List<Value> values4 = new ArrayList<>();
        values4.add(new IntegerValue(2));
        values4.add(lv3);
        ListValue lv4 = new ListValue(values4);
        
        assertEquals(new IntegerValue(1), data.get(0));
        assertEquals(lv4, data.get(1));
        assertEquals(new IntegerValue(8), data.get(2));
        assertEquals(new IntegerValue(9), data.get(3));
    }
    
    @Test
    public void testParseInteger10() {
        final String line = "[[10,4],4,10]";
        final Packet packet = createTestSubject().parsePacket(line);
        
        List<Value> data = packet.getData();
        assertEquals(3, data.size());
        
        List<Value> values1 = new ArrayList<>();
        values1.add(new IntegerValue(10));
        values1.add(new IntegerValue(4));
        assertEquals(new ListValue(values1), data.get(0));

        assertEquals(new IntegerValue(4), data.get(1));
        assertEquals(new IntegerValue(10), data.get(2));
    }
    
    private PacketParser createTestSubject() {
        return new PacketParser();
    }
}
