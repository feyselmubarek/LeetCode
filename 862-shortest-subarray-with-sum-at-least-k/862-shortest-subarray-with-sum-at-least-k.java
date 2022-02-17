class Solution {
    public int shortestSubarray(int[] A, int K) {
        long sum = 0;
        int min = A.length + 1;
        ArrayDeque<Pair<Long, Integer>> deque = new ArrayDeque<>();
        deque.addFirst(new Pair<>(0l, -1));
        
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            
            while(!deque.isEmpty() && deque.peekLast().getKey() >= sum){
                deque.removeLast();
            }
            
            deque.addLast(new Pair<>(sum, i));
            while(!deque.isEmpty() && (deque.peekLast().getKey() - deque.peekFirst().getKey()) >= K){
                min = Math.min(min, deque.peekLast().getValue() - deque.removeFirst().getValue());
            }
        }
        
        return min == A.length + 1 ? -1: min;
    }
}
