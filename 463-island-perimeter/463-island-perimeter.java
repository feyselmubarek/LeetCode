class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        HashSet<State> seen = new HashSet<>();
        
        // seen.add(new State(0, 1));
        // System.out.println(seen.contains(new State(0, 1)) + " : " +seen);
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 1 && !seen.contains(new State(row, col))){
                    seen.add(new State(row, col));
                    return dfs(grid, row, col, seen);
                }
            }
        }
        
        return 0;
    }
    
    public int dfs(int[][] grid, int row, int col, HashSet<State> seen){
        int side = 0, count = 0;
        
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int[] d : directions){
            int _row = row + d[0];
            int _col = col + d[1];
            
            if(_row < 0 || _row >= grid.length || _col < 0 || _col >= grid[_row].length || grid[_row][_col] == 0){
                side++;
                continue;
            }
            
            State newState = new State(_row, _col);
            
            if(!seen.contains(newState)){
                seen.add(newState);
                count += dfs(grid, _row, _col, seen);
            }
        }
        
        return side + count;
    }
}

class State{
    int x, y;
    public State(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override 
    public int hashCode(){
        return Objects.hash(x, y);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof State){
            State otherState = (State) obj;
            return this.x == otherState.x && this.y == otherState.y;
        }
        
        return false;
    }
}