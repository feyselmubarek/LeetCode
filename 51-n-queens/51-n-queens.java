class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(char[] row : chess) Arrays.fill(row, '.');
        
        List<List<String>> ans = new ArrayList<>();
        putQueen(0, n, chess, ans, new int[n][n]);
        return ans;
    }
    
    public void putQueen(int row, int n, char[][] chess, List<List<String>> ans, int[][] blocked){
        if(row == n){
            List<String> possible = new ArrayList<>();
            for(char[] r : chess){
                possible.add(new String(r));
            }
            ans.add(possible);
            return;
        }
        
        int[][] directions = {{1,0}, {1,1}, {1,-1}};
        
        for(int col = 0; col < n; col++){
            if(blocked[row][col] == 0){
                
                chess[row][col] = 'Q'; 
                for(int[] d : directions){
                    int _r = row + d[0], _c = col + d[1];                    
                    while(_r >= 0 && _r < n && _c < n && _c >= 0){
                        blocked[_r][_c]++;
                        _r += d[0];
                        _c += d[1];
                    }
                 }
                
                putQueen(row + 1, n, chess, ans, blocked);
                
                chess[row][col] = '.';
                for(int[] d : directions){
                    int _r = row + d[0], _c = col + d[1];                    
                    while(_r >= 0 && _r < n && _c < n && _c >= 0){
                        blocked[_r][_c]--;
                        _r += d[0];
                        _c += d[1];
                    }
                }
            }
        }
    }
}