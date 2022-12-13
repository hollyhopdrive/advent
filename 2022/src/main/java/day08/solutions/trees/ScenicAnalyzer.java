package day08.solutions.trees;

import lombok.RequiredArgsConstructor;
import shared.Grid;
import shared.GridAnalyzer;

@RequiredArgsConstructor
public class ScenicAnalyzer implements GridAnalyzer {
    
    private final Grid grid;
    
    public int analyze() {
    
        int maxScore = 0;
        
        // We know the scenic score for all outer trees is 0, so don't consider them
        for(int x = 1; x < grid.getSizeX() - 1; ++x) {
            for(int y = 1; y < grid.getSizeY() -1; ++y) {
                maxScore = Math.max(maxScore,  scenicScore(x, y));
            }
        }
        
        return maxScore;
    }
    
    public int scenicScore(int x, int y) {
        return countVisibleLeft(x, y) * 
                countVisibleRight(x,y) * 
                countVisibleUp(x, y) * 
                countVisibleDown(x, y);
    }
    
    private int countVisibleLeft(int x, int y) {
        int visible = 0;
        int pointer = x - 1;
        while(pointer >= 0) {
            visible++;
            if(grid.getValue(pointer, y) >= grid.getValue(x, y)) {
                break;
            }
            pointer--;
        }
        return visible;
    }
    
    private int countVisibleRight(int x, int y) {
        int visible = 0;
        int pointer = x + 1;
        while(pointer < grid.getSizeX()) {
            visible++;
            if(grid.getValue(pointer, y) >= grid.getValue(x, y)) {
                break;
            }
            pointer++;
        }
        return visible;
    }
    
    private int countVisibleUp(int x, int y) {
        int visible = 0;
        int pointer = y - 1;
        while(pointer >= 0) {
            visible++;
            if(grid.getValue(x, pointer) >= grid.getValue(x, y)) {
                break;
            }
            pointer--;
        }
        return visible;
    }
    
    private int countVisibleDown(int x, int y) {
        int visible = 0;
        int pointer = y + 1;
        while(pointer < grid.getSizeY()) {
            visible++;
            if(grid.getValue(x, pointer) >= grid.getValue(x, y)) {
                break;
            }
            pointer++;
        }
        return visible;
    }

}
