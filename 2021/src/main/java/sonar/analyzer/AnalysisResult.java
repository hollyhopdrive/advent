package sonar.analyzer;

import lombok.RequiredArgsConstructor;

/**
 * Result of a sonar analysis
 */
@RequiredArgsConstructor
public class AnalysisResult {

    private final String analysis;
    
    public void print() {
        System.out.println(analysis);
    }
}
