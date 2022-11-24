package sonar.data;

import lombok.RequiredArgsConstructor;

/**
 * Simple implementation of discrete (single) sonar readings
 */
@RequiredArgsConstructor
public class DiscreteSonarData implements SonarData {

    private final int[] data;
    
    @Override
    public int[] get() {
        return data;
    }
}
