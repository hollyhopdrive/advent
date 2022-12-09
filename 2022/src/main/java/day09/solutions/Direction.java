package day09.solutions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Direction {

    U(0,1),
    D(0,-1),
    R(1, 0),
    L(-1, 0);
    
    private final int xAdjust;
    private final int yAdjust;
}
