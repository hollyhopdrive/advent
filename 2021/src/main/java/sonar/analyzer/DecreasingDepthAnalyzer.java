package sonar.analyzer;

import java.util.stream.IntStream;

import sonar.Sonar;
import sonar.data.SlidingWindowSonarData;

public class DecreasingDepthAnalyzer extends SonarAnalyzer {

    private final int window;
    
    public DecreasingDepthAnalyzer(final Sonar sonar, final int window) {
        super(sonar);
        this.window = window;
    }
    
    @Override
    public AnalysisResult analyze() {
        int[] sweep = window == 1 ? sweep().get() : new SlidingWindowSonarData(sweep(), window).get();
        return new AnalysisResult(String.valueOf(IntStream.range(1, sweep.length).filter(i -> sweep[i] > sweep[i-1]).toArray().length));
    }
}
