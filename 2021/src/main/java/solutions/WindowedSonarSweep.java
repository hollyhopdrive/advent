package solutions;

import environment.Seabed;
import sonar.Sonar;
import sonar.analyzer.DecreasingDepthAnalyzer;
import sonar.analyzer.SonarAnalyzer;

public class WindowedSonarSweep {

    public static void main(String args[]) {
        
        Seabed seabed = new Seabed(args);
        SonarAnalyzer analyzer = new DecreasingDepthAnalyzer(new Sonar(seabed), 3);
        analyzer.analyze().print();
    }
}
