package day7.solutions.filesystem.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import day7.solutions.filesystem.FileSystem;
import day7.solutions.filesystem.Node;
import day7.solutions.filesystem.NodeSizeComparator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DirectoryDeleter implements DirectoryOperation {

    private final int requiredSpace;
    
    private final List<Node> candidates = new ArrayList<Node>();
    
    @Override
    public int operate(final FileSystem fs) {
        
        final int freeSpace = fs.getFreeSpace();  
        final int amountToDelete = requiredSpace - freeSpace;
        
        
        walk(fs.cd(FileSystem.ROOT), amountToDelete);
        
        Collections.sort(candidates, new NodeSizeComparator());
        return candidates.get(0).getSize();
    }
    
    private void walk(Node node, int amountToDelete) {
        node.getChildren().forEach(n -> walk(n, amountToDelete));
        if(node.isDir() && node.getSize() >= amountToDelete) {
            candidates.add(node);
        }
    }
}
