package day7.solutions.filesystem;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

public class File extends NamedNode {

    @Getter
    private final int size;
    
    public File(final Node parent, final String name, final int size) {
        super(parent, name);
        this.size = size;
    }

    @Override
    public boolean isDir() {
        return false;
    }
    
    @Override
    public List<Node> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void add(Node node) {
        throw new UnsupportedOperationException("Cannot add a child to a File node");
    }
}
