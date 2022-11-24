class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(word.charAt(0) == board[r][c]){
                    if(dfs(board, r, c, 1, word, new boolean[n][m])){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int r, int c, int index, String word, boolean[][] set){
        if(index >= word.length()){
            return true;
        }
        
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        set[r][c] = true;
        
        for(int[] direction : directions){
            int _r = r + direction[0];
            int _c = c + direction[1];
            
            if(_r < 0 || _r >= board.length || 
               _c < 0 || _c >= board[_r].length || 
              set[_r][_c] || board[_r][_c] != word.charAt(index)){
                continue;
            }
                
            if(dfs(board, _r, _c, index + 1, word, set)){
                return true;
            };
        }
        
        set[r][c] = false;
        return false;
    }
}