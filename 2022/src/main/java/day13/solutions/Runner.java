package day13.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import day13.solutions.packets.Packet;
import day13.solutions.packets.PacketParser;
import day13.solutions.packets.ListValueComparator;
import shared.Counter;
import shared.InputReader;

public class Runner {

    public static int runPuzzle1(final String path) {

        final List<Packet> packets = createPackets(path);
        
        final Counter rightOrderIndexSum = new Counter();
        final ListValueComparator comparator = new ListValueComparator();
        
        for(int p = 1, i = 0; i < packets.size(); p++, i+=2) {
            Packet p1 = packets.get(i);
            Packet p2 = packets.get(i+1);
            
            if(comparator.compare(p1, p2) < 0) {
                rightOrderIndexSum.add(p);
            } 
        }
        
        return rightOrderIndexSum.getValue();
    }
    
    public static int runPuzzle2(final String path) {
        
        final Packet divider1 = new PacketParser().parsePacket("[[2]]");
        final Packet divider2 = new PacketParser().parsePacket("[[6]]");
        
        final List<Packet> packets = createPackets(path);
        packets.add(divider1);
        packets.add(divider2);
        
        Collections.sort(packets, new ListValueComparator());

        return (packets.indexOf(divider1) + 1) * (packets.indexOf(divider2) + 1);
    }
    
    private static List<Packet> createPackets(final String path) {
        
        final List<Packet> packets = new ArrayList<>();
        
        final List<String> input = new InputReader().readChunks(path, "\n\n");
        for(int i = 1; i <= input.size(); ++i) {
            String[] packetLines = input.get(i-1).split("\n");
            packets.add(new PacketParser().parsePacket(packetLines[0]));
            packets.add(new PacketParser().parsePacket(packetLines[1]));
        }
        
        return packets;
    }
}
