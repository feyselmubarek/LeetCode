class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] directionMatrix = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 1){
                    max = Math.max(max, dfs(grid, row, col, directionMatrix, row + " : " + col));
                }
            }
        }
        
        return max;
    }
    
    public int dfs(int[][] grid, int row, int col, int[][] directionMatrix, String call){
        grid[row][col] = 0;
        int count = 1;
        
        for(int[] direction : directionMatrix){
            int _row = row + direction[0];
            int _col = col + direction[1];
            
            if(_row < 0 || _row == grid.length ||
               _col < 0 || _col == grid[row].length ||
               grid[_row][_col] != 1){
                continue;
            }
            
            count += dfs(grid, _row, _col, directionMatrix, call);
        }
        
        return count;
    }
}