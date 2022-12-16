package shared;

import lombok.RequiredArgsConstructor;

/**
 * Applies an offset to a Grid, so that it's origin is not 0,0
 */
@RequiredArgsConstructor
public class GridOffsetAdapter {

    final int offsetX;
    final int offsetY;
}
