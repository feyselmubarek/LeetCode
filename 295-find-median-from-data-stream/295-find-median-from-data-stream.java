class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        balanceHeap();
    }
    
    public void balanceHeap() {
        if(Math.abs(maxHeap.size() - minHeap.size()) < 2){
            return;
        }
        
        PriorityQueue<Integer> smaller = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> larger = minHeap.size() > maxHeap.size() ? minHeap: maxHeap;
        smaller.add(larger.poll());
    }
    
    public double findMedian() {
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            return 0.0;
        }
        
        if(maxHeap.size() == minHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        
        PriorityQueue<Integer> larger = minHeap.size() > maxHeap.size() ? minHeap: maxHeap;
        return larger.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */