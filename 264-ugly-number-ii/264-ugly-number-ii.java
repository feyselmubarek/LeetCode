class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> seen = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        seen.add(1l);
        minHeap.add(1l);
        
        int[] multiply = {2, 3, 5};
        
        for(int i = 1; i < n; i++){
            long num = minHeap.poll();
            
            for(int m : multiply){
                if(!seen.contains(num * m) && num < Integer.MAX_VALUE){
                    seen.add(num * m);
                    minHeap.add(num * m);
                }
            }
        }
        
        return (int) (long) minHeap.peek();
    }
}