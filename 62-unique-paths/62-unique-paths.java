class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(r - 1 >= 0){
                    dp[r][c] += dp[r - 1][c];
                }
                
                if(c - 1 >= 0){
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}