package sonar.data;

import java.util.stream.IntStream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SlidingWindowSonarData implements SonarData {

    private final SonarData data;
    private final int window;

    @Override
    public int[] get() {
        int[] values = data.get();

        // This seems a bit brute force...
        int[] tmp = IntStream.range(0, values.length - (window - 1)).map(i -> {
            int sum = values[i];
            for (int j = i + 1; j < i + window; ++j) {
                sum += values[j];
            }
            return sum;
        }).toArray();
        return tmp;
    }
}
