package shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Direction {

    U(-1,0),
    D(1,0),
    R(0, 1),
    L(0, -1);
    
    private final int yAdjust;
    private final int xAdjust;
}
