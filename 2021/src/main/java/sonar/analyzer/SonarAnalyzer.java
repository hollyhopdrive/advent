package sonar.analyzer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import sonar.Sonar;
import sonar.data.SonarData;

/**
 * Analyzes sonar data in some way
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SonarAnalyzer {

    private final Sonar sonar;

    protected SonarData sweep() {
        return sonar.sweep();
    }

    public abstract AnalysisResult analyze();
}
