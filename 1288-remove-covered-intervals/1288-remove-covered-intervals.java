class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        boolean[] removed = new boolean[intervals.length];
        int count = 0;
        
        for(int i = 0; i < intervals.length; i++){
            int[] a = intervals[i];
            for(int j = 0; j < intervals.length; j++){
                if(i == j || removed[j]) continue;
                int[] b = intervals[j];
                
                if(a[0] <= b[0] && b[1] <= a[1]){
                    removed[j] = true;
                    count++;
                }
            }
        }
        
        return intervals.length - count;
    }
}