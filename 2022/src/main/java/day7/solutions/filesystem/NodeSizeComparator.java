package day7.solutions.filesystem;

import java.util.Comparator;

public class NodeSizeComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        return node1.getSize() - node2.getSize();
    }
}
