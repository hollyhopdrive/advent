package sonar.data;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscreteSonarData implements SonarData {

    private final int[] data;
    
    @Override
    public int[] get() {
        return data;
    }
}
