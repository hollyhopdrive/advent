package day7.solutions.filesystem.operations;

import day7.solutions.filesystem.FileSystem;
import day7.solutions.filesystem.Node;
import lombok.RequiredArgsConstructor;
import shared.Counter;

@RequiredArgsConstructor
public class DirectorySizeAggregator implements DirectoryOperation {

    private final Counter counter = new Counter();
    private final int threshold;
    
    public int operate(final FileSystem fs) {
        
        Node aggRoot = fs.getCwd();
        walk(aggRoot);
        return counter.getValue();
        
    }
    
    private void walk(Node node) {
        node.getChildren().forEach(n -> walk(n));
        if(node.isDir() && node.getSize() <= threshold) {
            counter.add(node.getSize());
        }
    }
}
