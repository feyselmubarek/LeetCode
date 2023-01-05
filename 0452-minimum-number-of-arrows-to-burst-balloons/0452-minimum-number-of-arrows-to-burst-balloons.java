class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int last = points[0][1], arrows = 1;
        
        for(int idx = 1; idx < points.length; idx++){
            if(last < points[idx][0]){
                last = points[idx][1];
                arrows++;    
            }
            
        }
        
        return arrows;
    }
}