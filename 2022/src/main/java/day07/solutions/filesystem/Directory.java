package day07.solutions.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends NamedNode {

    private final List<Node> children = new ArrayList<>();
    
    public Directory(final Node parent, final String name) {
        super(parent, name);
    }

    @Override
    public boolean isDir() {
        return true;
    }
    
    @Override
    public int getSize() {
        return children.stream().map(c -> c).collect(Collectors.summingInt(Node::getSize));
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void add(Node node) {
        children.add(node);
    }
}
