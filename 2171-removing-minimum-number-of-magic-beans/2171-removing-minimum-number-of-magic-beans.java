class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for(int bean : beans) sum += (long) bean;
            
        long min = sum;        
        for(int i = 0; i < beans.length; i++){
            int size = beans.length - i;
            min = Math.min(min, sum - ((long) beans[i] * size));
        }
        
        return min;
    }
}