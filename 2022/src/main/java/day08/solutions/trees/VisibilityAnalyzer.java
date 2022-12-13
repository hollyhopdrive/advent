package day08.solutions.trees;

import lombok.RequiredArgsConstructor;
import shared.Counter;
import shared.Grid;
import shared.GridAnalyzer;

@RequiredArgsConstructor
public class VisibilityAnalyzer implements GridAnalyzer {

    private final Grid grid;
    
    public int analyze() {

        Counter visible = new Counter();
        visible.add(outerTrees());
        
        // Iterate over every inner tree, check for visibility
        for(int y = 1; y < grid.getSizeY() - 1; ++y) {
            for(int x = 1; x < grid.getSizeX() -1; ++x) {
                if(isVisible(y, x)) {
                    visible.increment();
                }
            }
        }
        
        return visible.getValue();
    }
    
    public int outerTrees() {
        return 4 * grid.getSizeX() - 4;
    }
    
    public boolean isVisible(int y, int x) {
        return isVisibleLeft(y, x) || isVisibleRight(y, x) || isVisibleUp(y, x) || isVisibleDown(y, x);
    }
    
    private boolean isVisibleLeft(int y, int x) {
        int pointer = x - 1;
        while(pointer >= 0) {
            if(grid.getValue(y, pointer) >= grid.getValue(y, x)) {
                return false;
            }
            pointer--;
        }
        return true;
    }
    
    private boolean isVisibleRight(int y, int x) {
        int pointer = x + 1;
        while(pointer < grid.getSizeX()) {
            if(grid.getValue(y, pointer) >= grid.getValue(y, x)) {
                return false;
            }
            pointer++;
        }
        return true;
    } 
    
    private boolean isVisibleUp(int y, int x) {
        int pointer = y - 1;
        while(pointer >= 0) {
            if(grid.getValue(pointer, x) >= grid.getValue(y, x)) {
                return false;
            }
            pointer--;
        }
        return true;
    }
    
    private boolean isVisibleDown(int y, int x) {
        int pointer = y + 1;
        while(pointer < grid.getSizeY()) {
            if(grid.getValue(pointer, x) >= grid.getValue(y, x)) {
                return false;
            }
            pointer++;
        }
        return true;
    }
}
