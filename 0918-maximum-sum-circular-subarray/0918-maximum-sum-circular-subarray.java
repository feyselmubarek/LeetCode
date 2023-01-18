class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int prevMax = -30001, maxSum = -30001, prevMin = 30001, minSum = 30001, sum = 0;
        
        for(int idx = 0; idx < A.length; idx++){
            prevMax = Math.max(A[idx], prevMax + A[idx]);
            prevMin = Math.min(A[idx], prevMin + A[idx]);
            
            sum += A[idx];
            
            minSum = Math.min(minSum, prevMin);
            maxSum = Math.max(maxSum, prevMax);
        }
        
        if(minSum == sum){
            return maxSum;
        }
        
        return Math.max(maxSum, sum - minSum);
    }
}