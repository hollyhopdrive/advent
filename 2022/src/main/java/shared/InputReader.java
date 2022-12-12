package shared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.io.Resources;

public class InputReader {

    public List<String> readInputFile(final String path) {
        BufferedReader reader = read(path);
        return reader.lines().collect(Collectors.toList());
    }
    
    public List<String> readChunks(final String path, final String splitOn) {
        String content;
        try {
            content = Resources.toString(Resources.getResource(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(content.split(splitOn));
    }
    
    private BufferedReader read(final String path) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        return new BufferedReader(new InputStreamReader(stream));
    }
}
