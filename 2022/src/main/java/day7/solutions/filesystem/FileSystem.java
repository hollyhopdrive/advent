package day7.solutions.filesystem;

import java.util.List;

import lombok.Getter;

public class FileSystem {

    private static final int TOTAL_SPACE = 70000000;
    
    public static final String ROOT = "/";
    public static final String UP = "..";
    
    private Directory root;
    
    @Getter
    private Node cwd;

    /**
     * What is the size of the device?
     */
    public int getTotalSpace() {
        return TOTAL_SPACE;
    }
    
    /**
     * How much free space is on the device? If there is no root, then all of it is free
     */
    public int getFreeSpace() {
        if(root == null) {
            return TOTAL_SPACE;
        }
        
        return getTotalSpace() - root.getSize();
    }

    /**
     * Execute the 'cd' command
     * @return the new working directory, or the cwd if the dir is not found
     */
    public Node cd(final String name) {
        switch(name) {
            case ROOT: cwd = root; break;
            case UP: cwd = cwd.getParent(); break;
            default: {
                Node child = findChild(name);
                cwd = child != null ? child : cwd;
            }
        }
        return cwd;
    }
    
    /**
     * Execute the 'ls' command
     */
    public List<Node> ls() {
        return cwd.getChildren();
    }
    
    /**
     * Check if the node exists as a child of the current node
     */
    public boolean exists(final String name) {
        if(name.equals(ROOT)) {
            return root != null;
        }
        return findChild(name) != null;
    }
    
    /**
     * Create a new dir
     */
    public void mkdir(final String name) {
        if(name.equals(ROOT)) {
            root = new Directory(null, name);
            cwd = root;
        } else {
            cwd.add(new Directory(cwd, name));
        }
    }
    
    /**
     * Create a new file
     */
    public void create(final String name, final int size) {
        cwd.add(new File(cwd, name, size));
    }
    
    private Node findChild(final String name) {
        return ls().stream().filter(c -> c.isDir() && name.equals(c.getName())).findAny().orElse(null);
    }
}
 