package day11.solutions.monkeybusiness;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MonkeyTest {

    @Getter
    private final int denominator;
    
    public boolean apply(BigDecimal value) {
        return value.remainder(BigDecimal.valueOf(denominator)) == BigDecimal.ZERO;
    }
} 
