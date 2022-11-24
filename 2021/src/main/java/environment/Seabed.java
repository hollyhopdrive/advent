package environment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents the sea bed environment, used by the sonar sweep to get data
 *
 */
@RequiredArgsConstructor
public class Seabed {

    @Getter
    private final String[] depths; 
}
