class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int n = maze.length;
        int m = maze[0].length;
        
        Queue<int[]> cur = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        cur.add(entrance);
        visited.add(entrance[0] + "," + entrance[1]);  
        
        int ans = 0;
        while(!cur.isEmpty()){
            int size = cur.size();
            for(int i = 0; i < size; i++){
                int[] polled = cur.poll();
                for(int j = 0; j < 4; j++){
                    int newR = polled[0] + dir[j][0];
                    int newC = polled[1] + dir[j][1];
                    if(isOutB(newC, newR, n, m)){
                        if(ans != 0){
                            return ans;                            
                        }
                    }else if(maze[newR][newC] == '.' && !visited.contains(newR + "," + newC)){
                        cur.add(new int[] {newR, newC});
                        visited.add(newR + "," + newC);    
                    }                
                }
            }
            
            ans++;
        }
        
        return -1;
        
    }
    
   boolean isOutB(int c, int r,int n, int m){
        return c < 0 || r >= n || r < 0 || c >= m;
    }
}