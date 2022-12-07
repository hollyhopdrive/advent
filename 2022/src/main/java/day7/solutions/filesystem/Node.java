package day7.solutions.filesystem;

import java.util.List;

/**
 * A File System node
 */
public interface Node {
    
    /**
     * The name of the node
     */
    String getName();
    
    /**
     * Is it a directory?
     */
    boolean isDir();
    
    /**
     * The size of the data in this node
     * 0 if it is a directory, or the size of the file is it is a file
     */
    int getSize();
    
    /**
     * Get this node's parent
     */
    Node getParent();
    
    /**
     * Get the children of this node
     */
    List<Node> getChildren();
    
    /**
     * Add a new child node
     */
    void add(Node node);
}
