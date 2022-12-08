package day08.solutions.trees;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScenicAnalyzer implements GridAnalyzer {
    
    public int analyze(char[][] grid) {
    
        int maxScore = 0;
        
        // We know the scenic score for all outer trees is 0, so don't consider them
        for(int x = 1; x < grid.length - 1; ++x) {
            for(int y = 1; y < grid[0].length -1; ++y) {
                maxScore = Math.max(maxScore,  scenicScore(x, y, grid));
            }
        }
        
        return maxScore;
    }
    
    public int scenicScore(int x, int y, char[][] grid) {
        return countVisibleLeft(x, y, grid) * 
                countVisibleRight(x,y, grid) * 
                countVisibleUp(x, y, grid) * 
                countVisibleDown(x, y, grid);
    }
    
    private int countVisibleLeft(int x, int y, char[][] grid) {
        int visible = 0;
        int pointer = x - 1;
        while(pointer >= 0) {
            visible++;
            if(grid[pointer][y] >= grid[x][y]) {
                break;
            }
            pointer--;
        }
        return visible;
    }
    
    private int countVisibleRight(int x, int y, char[][] grid) {
        int visible = 0;
        int pointer = x + 1;
        while(pointer < grid.length) {
            visible++;
            if(grid[pointer][y] >= grid[x][y]) {
                break;
            }
            pointer++;
        }
        return visible;
    }
    
    private int countVisibleUp(int x, int y, char[][] grid) {
        int visible = 0;
        int pointer = y - 1;
        while(pointer >= 0) {
            visible++;
            if(grid[x][pointer] >= grid[x][y]) {
                break;
            }
            pointer--;
        }
        return visible;
    }
    
    private int countVisibleDown(int x, int y, char[][] grid) {
        int visible = 0;
        int pointer = y + 1;
        while(pointer < grid[0].length) {
            visible++;
            if(grid[x][pointer] >= grid[x][y]) {
                break;
            }
            pointer++;
        }
        return visible;
    }
}
