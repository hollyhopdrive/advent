package day7.solutions.filesystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class NamedNode implements Node {

    @Getter
    private final Node parent;
    
    @Getter
    private final String name;
}
