package sonar;

import java.util.stream.IntStream;

import environment.Seabed;
import lombok.RequiredArgsConstructor;
import sonar.data.DiscreteSonarData;
import sonar.data.SonarData;

@RequiredArgsConstructor
public class Sonar {

    private final Seabed environment;
    
    /**
     * Converts raw (String input data) from the environment into usable quantitative readings
     *
     * @author pmcarthur
     */
    private static class DataAdapter {
        private final String[] raw;
        
        private DataAdapter(final String[] raw) {
            this.raw = raw;
        }
        
        public int[] get() {
            return IntStream.range(0, raw.length).map(i -> Integer.parseInt(raw[i])).toArray();
        }
    }
    
    public SonarData sweep() {
        return new DiscreteSonarData(new DataAdapter(environment.getDepths()).get());
    }
}
