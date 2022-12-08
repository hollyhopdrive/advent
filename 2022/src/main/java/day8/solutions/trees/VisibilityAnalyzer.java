package day8.solutions.trees;

import lombok.RequiredArgsConstructor;
import shared.Counter;

@RequiredArgsConstructor
public class VisibilityAnalyzer implements GridAnalyzer {

    public int analyze(char[][] grid) {

        Counter visible = new Counter();
        visible.add(outerTrees(grid));
        
        // Iterate over every inner tree, check for visibility
        for(int x = 1; x < grid.length - 1; ++x) {
            for(int y = 1; y < grid[0].length -1; ++y) {
                if(isVisible(x, y, grid)) {
                    visible.increment();
                }
            }
        }
        
        return visible.getValue();
    }
    
    public int outerTrees(char[][] grid) {
        return 4 * grid.length - 4;
    }
    
    public boolean isVisible(int x, int y, char[][] grid) {
        return isVisibleLeft(x, y, grid) || isVisibleRight(x, y, grid) || isVisibleUp(x, y, grid) || isVisibleDown(x, y, grid);
    }
    
    private boolean isVisibleLeft(int x, int y, char[][] grid) {
        int pointer = x - 1;
        while(pointer >= 0) {
            if(grid[pointer][y] >= grid[x][y]) {
                return false;
            }
            pointer--;
        }
        return true;
    }
    
    private boolean isVisibleRight(int x, int y, char[][] grid) {
        int pointer = x + 1;
        while(pointer < grid[x].length) {
            if(grid[pointer][y] >= grid[x][y]) {
                return false;
            }
            pointer++;
        }
        return true;
    } 
    
    private boolean isVisibleUp(int x, int y, char[][] grid) {
        int pointer = y - 1;
        while(pointer >= 0) {
            if(grid[x][pointer] >= grid[x][y]) {
                return false;
            }
            pointer--;
        }
        return true;
    }
    
    private boolean isVisibleDown(int x, int y, char[][] grid) {
        int pointer = y + 1;
        while(pointer < grid[x].length) {
            if(grid[x][pointer] >= grid[x][y]) {
                return false;
            }
            pointer++;
        }
        return true;
    }
}
