class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(char[] row : chess) Arrays.fill(row, '.');
        
        List<List<String>> ans = new ArrayList<>();
        HashSet<Integer> plusDiagonal = new HashSet<>();
        HashSet<Integer> minusDiagonal = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        putQueen(0, n, chess, ans, plusDiagonal, minusDiagonal, columns);
        return ans;
    }
    
    public void putQueen(int row, int n, char[][] chess, List<List<String>> ans, HashSet<Integer> plusDiagonal, HashSet<Integer> minusDiagonal, HashSet<Integer> columns){
        if(row == n){
            List<String> possible = new ArrayList<>();
            for(char[] r : chess){
                possible.add(new String(r));
            }
            ans.add(possible);
            return;
        }
        
        for(int col = 0; col < n; col++){
            if(!plusDiagonal.contains(row + col) && !minusDiagonal.contains(row - col) && !columns.contains(col)){
                plusDiagonal.add(row + col);
                minusDiagonal.add(row - col);
                columns.add(col);
                
                chess[row][col] = 'Q';                 
                putQueen(row + 1, n, chess, ans, plusDiagonal, minusDiagonal, columns);
                chess[row][col] = '.';
                
                plusDiagonal.remove(row + col);
                minusDiagonal.remove(row - col);
                columns.remove(col);
            }
        }
    }
}