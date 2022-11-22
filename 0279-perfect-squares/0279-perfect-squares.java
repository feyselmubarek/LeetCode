class Solution {
    public int numSquares(int n) {
        HashMap<Integer, Integer> start = new HashMap<>(), end = new HashMap<>();
        start.put(0, 0);
        end.put(n, 0);
        
        return biBfs(start, end, 1, n);
    }
    
    public int biBfs(HashMap<Integer, Integer> start, HashMap<Integer, Integer> end, int sign, int n) {
        HashMap<Integer, Integer> mine = new HashMap<>();
        
        for(int num : start.keySet()){
            int limit = (int) Math.sqrt(n);
            int steps = start.get(num);
            
            for(int sqr = limit; sqr >= 0; sqr--){
                int newNum = num + (sign * sqr * sqr);
                
                if(newNum < 0 || newNum > n){
                    continue;
                }
                
                if(end.containsKey(newNum)){
                    return steps + end.get(newNum) + 1;
                }
                
                mine.put(newNum, steps + 1);
            }
        }
        
        if(mine.isEmpty()){
            return -1;
        }
        
        return biBfs(end, mine, sign * -1, n);
    }
}