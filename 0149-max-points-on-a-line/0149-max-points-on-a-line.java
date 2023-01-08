class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length, best = 0;
        HashMap<String, Integer> lines = new HashMap<>();
        
        for(int idx = 0; idx < len; idx++){
            int[] pointA = points[idx];
            lines = new HashMap<>();
            int max = 1, verticalLinePts = 1, overlapping = 0;
            
            for(int itr = idx + 1; itr < len; itr++){
                int[] pointB = points[itr];  
                int changeY = pointB[1] - pointA[1];
                int changeX = pointB[0] - pointA[0];
                int gcd = calculateGcd(changeX, changeY);
                
                if(changeY == 0 && changeX == 0){
                    overlapping++;
                }else if(changeX == 0){
                    verticalLinePts++;
                }else{
                    String slope = (changeY / gcd) + "/" + (changeX / gcd);
                    int pts = lines.getOrDefault(slope, 1);
                    lines.put(slope, pts + 1);
                    max = Math.max(max, pts + 1);
                }
            }
            
            best = Math.max(best, Math.max(verticalLinePts, max) + overlapping);
        }
        
        return best;
    }
    
    public int calculateGcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return calculateGcd(b, a % b);
    }
}