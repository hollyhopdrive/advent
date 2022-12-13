package day13.solutions.packets;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Packet {

    @Getter
    private final List<Value> data;
    
}
