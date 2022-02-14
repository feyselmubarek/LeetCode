class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for(int bean : beans) sum += (long) bean;
            
        long min = sum;
        long removed = 0;
        
        for(int i = 0; i < beans.length; i++){
            long bean = beans[i];
            int size = beans.length - i;
            long rm = sum - (bean * size);
            min = Math.min(min, rm);
        }
        
        return min;
    }
}