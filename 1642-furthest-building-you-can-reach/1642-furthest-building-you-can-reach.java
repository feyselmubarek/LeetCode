class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int n = heights.length;
        for(int i = 0; i < n - 1; i++){
            int diff = heights[i + 1] - heights[i];
            if(diff > 0){
                if(ladders > 0){
                    ladders--;
                    heap.add(diff);
                }else {
                    heap.add(diff);
                    if(heap.peek() <= bricks){
                        bricks -= heap.poll();
                    }else{
                        return i;
                    }
                }
            }
        }
        
        return n - 1;
    }
}