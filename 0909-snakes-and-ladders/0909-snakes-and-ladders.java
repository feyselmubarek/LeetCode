class Solution {
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, Integer> snakeOrLadder = new HashMap<>();
        int N = board.length, pos = 1;
        
        for(int row = N - 1; row >= 0; row--){
            int direction = (N - row)  % 2 == 0 ? -1 : 1;
            int col = (N - row) % 2 == 0 ? N - 1 : 0;
            
            while(col >= 0 && col < N){
                if(board[row][col] != -1){
                    snakeOrLadder.put(pos, board[row][col]);
                }
                col += direction;
                pos++;
            }
        }
        
        int destination = N * N, level = 0;
        int[] dice = {1, 2, 3, 4, 5, 6};
        boolean[] seen = new boolean[destination + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        
        queue.add(1);
        seen[1] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int elements = 0; elements < size; elements++){
                int whereIAm = queue.poll();
                
                if(whereIAm == destination){
                    return level;
                }
                
                for(int possiblity : dice){
                    int whereIWillBe = whereIAm + possiblity;
                    int jump = snakeOrLadder.getOrDefault(whereIWillBe, 0);
                    whereIWillBe = jump != 0 ? jump : whereIWillBe;

                    if(whereIWillBe > destination || seen[whereIWillBe]){
                        continue;
                    }
                    
                    queue.add(whereIWillBe);
                    seen[whereIWillBe] = true;
                }
            }
            
            level++;
        }
        
        return -1;
    }
}