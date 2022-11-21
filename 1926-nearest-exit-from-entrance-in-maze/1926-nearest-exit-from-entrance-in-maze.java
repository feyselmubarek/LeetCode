class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        LinkedList<int[]> q = new LinkedList<>();
        int n = maze.length, m = maze[0].length;
        boolean[][] seen = new boolean[n][m];
        
        q.add(entrance);
        seen[entrance[0]][entrance[1]] = true;
        
        int level = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                if(isEnd(curr, n, m) && level != 0){
                    return level;
                }
                
                for(int[] direct: directions){
                    int r = curr[0] + direct[0];
                    int c = curr[1] + direct[1];
                    
                    if(r < 0 || r >= n || c < 0 || c >= m || seen[r][c] || maze[r][c] == '+'){
                        continue;
                    }
                    
                    q.add(new int[]{r, c});
                    seen[r][c] = true;
                }
            }
            level++;
        }
        
        return -1;
    }
    
    public boolean isEnd(int[] p, int n, int m){
        return p[0] == 0 || p[0] == n - 1 || p[1] == 0 || p[1] == m - 1;
    }
}