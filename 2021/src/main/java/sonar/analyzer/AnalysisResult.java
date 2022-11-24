package sonar.analyzer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnalysisResult {

    private final String analysis;
    
    public void print() {
        System.out.println(analysis);
    }
}
